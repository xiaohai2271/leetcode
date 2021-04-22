# 🙌About
leetcode 刷题的代码仓库

IDE :  **[Intellij IDEA](https://www.jetbrains.com/idea/)**

插件 :  [Leetcode-editor(修改版)](https://github.com/xiaohai2271/leetcode-editor)

插件配置 :

- CodeFilePath : `~\Desktop\leetcode\src\cn\celess`
- TempFilePath : `~\Desktop\leetcode\data`
- [x] Custom Template **开启自定义模板**
- [x] Show Acceptance **开启通过率显示**
- [ ] JCEF 
- [ ] English Content
- CodeFileName : `${question.difficulty}\\$!velocityTool.camelCaseName(${question.titleSlug}) `
- CodeTemplate : 
```
package cn.celess.medium;

import cn.celess.utils.*;

/**
 * @author : 禾几海
 * @date : $!velocityTool.date("yyyy年MM月dd日 hh:mm")
 * @difficulty : ${question.difficulty}
 * @desc :
 * @see <a href="https://leetcode-cn.com/problems/${question.titleSlug}">${question.frontendQuestionId}.${question.title}</a>
 */
public class $!velocityTool.camelCaseName(${question.titleSlug}) {

    public static void main(String[] args) {
        Solution solution = new $!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
        Assert assertion = Assert.getInstance();
    }
}
```
