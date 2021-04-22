package cn.celess.utils.v2;

/**
 * @author : xiaohai
 * @date : 2021/04/12 12:37
 * @desc :使用反射
 */

import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

import cn.celess.utils.*;
import cn.celess.utils.ListNodeUtil.*;
import cn.celess.utils.TreeNodeUtil.*;

public class Assert {
    public static final PrintStream out = System.out;
    //    public static final PrintStream err = System.out;// 顺序问题关闭
    private boolean isStrict = false;
    private boolean autoRecord = true;
    private String[] tips = null;
    private int tipIndex = 0;
    private long recordCount = 0;
    private long recordTime = 0;
    private Object expect = null;
    private Object actual = null;
    private boolean enablePrint = true;
    private Object[] args;
    private Object solutionClassInstance;
    private Method method;
    private String methodName;

    @FunctionalInterface
    public interface Function<T> {
        T apply();
    }

    /**
     * 设置严格模式 开启严格模式 如果断言错误则会抛错 否则不会影响程序执行，会给予一个提示
     *
     * @param isStrict 是否开启严格模式
     * @return 对象实例
     */
    public Assert setStrict(boolean isStrict) {
        this.isStrict = isStrict;
        return this;
    }

    /**
     * 设置调用print的提示 每次调用print 方法会按顺序输出提示
     *
     * @param tips 提示内容
     * @return 对象实例
     */
    public Assert setPrintTip(String[] tips) {
        this.tips = tips;
        return this;
    }

    public void setEnablePrint(boolean enablePrint) {
        this.enablePrint = enablePrint;
    }

    /**
     * 设置自动记录调用时长
     *
     * @param autoRecord 是否自动记录
     * @return 对象实例
     */
    public Assert setAutoRecord(boolean autoRecord) {
        this.autoRecord = autoRecord;
        return this;
    }

    public void setSolutionClassInstance(Object solutionClassInstance) {
        if (this.solutionClassInstance != null) {
            throw new IllegalArgumentException("solutionClassInstance has been set");
        }
        this.solutionClassInstance = solutionClassInstance;
        if (method == null) setMethod(methodName);
    }

    public void setMethod(String methodName) {
        if (this.method != null) {
            throw new IllegalArgumentException("method has been set");
        }
        if (solutionClassInstance != null)
            method = Arrays.stream(solutionClassInstance.getClass().getMethods()).filter(method1 -> method1.getName().equals(methodName)).findFirst().orElse(null);
    }

    public void execute() {
        Object[] obj = new Object[1];
        Thread thread = new Thread(() -> {
            long startRecordTime = System.nanoTime();
            try {
                obj[0] = method.invoke(solutionClassInstance, args);
                recordTime += System.nanoTime() - startRecordTime;
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
                System.err.println("找不到测试方法");
            }
        });
        thread.start();
        while (thread.isAlive()) ;
        actual = obj[0];
        if (expect != null) {
            assertEqual(expect, actual);
            expect = actual = null;
        } else {
            System.err.println("未设置期望值");
        }
    }


    /**
     * 期望值 记录调用时长
     *
     * @param f   待执行的逻辑
     * @param <T> 返回值类型
     * @return 对象实例
     */
    public <T> Assert actual(Function<T> f) {
        Object[] obj = new Object[1];
        Thread thread = new Thread(() -> {
            long startRecordTime = System.nanoTime();
            obj[0] = f.apply();
            recordTime += System.nanoTime() - startRecordTime;
        });
        thread.start();
        while (thread.isAlive()) ;
        return actual(obj[0]);
    }

    /**
     * @param ac  期望值
     * @param <T> 期望值类型
     * @return 对象实例
     */
    public <T> Assert actual(T ac) {
        actual = ac;
        if (expect != null) {
            assertEqual(expect, actual);
            expect = actual = null;
        }
        return this;
    }

    /**
     * @param f   执行的逻辑
     * @param <T> 实际值类型
     * @return 对象实例
     */
    public <T> Assert expect(Assert.Function<T> f) {
        return expect(f.apply());
    }

    /**
     * @param ex  实际值
     * @param <T> 实际值类型
     * @return 对象实例
     */
    public <T> Assert expect(T ex) {
        expect = ex;
        if (actual != null) {
            assertEqual(expect, actual);
            expect = actual = null;
        }
        return this;
    }

    /**
     * @param expect 期望值
     * @param actual 实际值
     * @return 对象实例
     */
    public boolean assertEqual(Object expect, Object actual) {
        boolean result = true;
        if (expect instanceof ListNode && actual instanceof ListNode) {
            ListNode exceptNode = (ListNode) expect;
            ListNode actualNode = (ListNode) actual;
            while (exceptNode != null && actualNode != null) {
                if (exceptNode.val != actualNode.val) {
                    result = false;
                    break;
                }
                exceptNode = exceptNode.next;
                actualNode = actualNode.next;
            }
        } else {
            result = expect == actual || (expect != null && expect.equals(actual)) || (actual != null && actual.equals(expect));
        }
        print("\nExpect: ");
        if (expect instanceof ListNode) {
            ListNodeUtil.foreach((ListNode) expect);
        } else {
            print(expect);
        }
        print("\nActual: ");
        if (actual instanceof ListNode) {
            ListNodeUtil.foreach((ListNode) actual);
        } else {
            print(actual);
        }

        if (!result && !isStrict) {
            printErr("\t\t\t<------- Assertion Error !!! ");

        }
        if (!result && isStrict) {
            throw new AssertionError("Assertion Error: expect " + expect + " but " + actual);
        }
        println();
        println();
        if (autoRecord) record();
        return result;
    }

    private void record() {
        recordCount++;
    }

    public Assert args(Object[] args) {
        this.args = args;
        return this;
    }


    public Assert printArgs() {
        return print(null, this.args);
    }

    /**
     * @param o 输出的对象
     * @return 对象实例
     */
    public Assert print(Object... o) {
        return print(null, o);
    }

    /**
     * @param msg 提示
     * @param o   输出值
     * @return 对象实例
     */
    public Assert print(String msg, Object... o) {
        if (tips != null && tips.length != 0) {
            print(tips[tipIndex++]);
            tipIndex %= tips.length;
        }
        if (o.length == 0 && msg != null) {
            o = new Object[]{msg};
            msg = null;
        }

        if (msg != null)
            print(msg + ":");
        print(o.length == 1 ? o[0] : Arrays.toString(o));

        //        print(" ");
        out.flush();
        return this;
    }

    public static boolean isArray(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.getClass().isArray();
    }

    /**
     * @return 对象实例
     */
    public Assert printRecordInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("=====================================================").append("\n");
        if (!autoRecord) {
            print(sb.toString());
            printErr("please set autoRecord field first!");
            return this;
        }
        sb.append(recordCount).append(" assertions \t").append("\n");
        sb.append("total   time consuming: ")
                .append(recordTime).append(" us")
                .append("\t")
                .append(recordTime / 1000.0).append(" ms")
                .append("\n");
        sb.append("average time consuming: ")
                .append(recordTime / recordCount).append(" us")
                .append("\t")
                .append((recordTime / 1000.0) / recordCount).append(" ms");
        println(sb.toString());
        out.flush();
        return this;
    }

    private void print(Object obj) {
        if (enablePrint) out.print(obj);
        out.flush();
    }

    private void printErr(Object obj) {
        print(obj);
    }

    private void println(Object obj) {
        print(obj);
        print("\n");
    }

    private void println() {
        print("\n");
    }
}
