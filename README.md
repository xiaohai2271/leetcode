# 🙌简介

leetcode 刷题的代码仓库

IDE :  **[Intellij IDEA](https://www.jetbrains.com/idea/)**,  **[Goland](https://www.jetbrains.com/go/)**

插件 :  [Leetcode-editor(修改版)](https://github.com/xiaohai2271/leetcode-editor)

## ⚙ 插件配置

### java

---

- CodeFilePath : `~\Desktop\leetcode\src\cn\celess`
- TempFilePath : `~\Desktop\leetcode\data`
- [x] Custom Template **开启自定义模板**
- [x] Show Acceptance **开启通过率显示**
- [ ] JCEF 
- [ ] English Content
- CodeFileName : `${question.difficulty}\\$!velocityTool.camelCaseName(${question.titleSlug}) `
- CodeTemplate : 
```
package cn.celess.${question.difficulty};

import cn.celess.utils.*;

/**
 * @author : 禾几海
 * @date : $!velocityTool.date("yyyy年MM月dd日 hh:mm")
 * @difficulty : ${question.difficulty}
 * @info submissions: ${question.submissions}       accepted: ${question.accepted}      acceptance: $!velocityTool.percentage(${question.accepted},${question.submissions})
 * @see <a href="https://leetcode-cn.com/problems/${question.titleSlug}">${question.frontendQuestionId}.${question.title}</a>
 * @desc :
 */
public class $!velocityTool.camelCaseName(${question.titleSlug}) {

    ${question.code}

    public static void main(String[] args) {
        Solution solution = new $!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
        Assert assertion = Assert.getInstance();
    }
}
```
### GO

---

- CodeFilePath : `~\Desktop\leetcode\go-src`
- TempFilePath : `~\Desktop\leetcode\data`
- [x] Custom Template **开启自定义模板**
- [x] Show Acceptance **开启通过率显示**
- [ ] JCEF
- [ ] English Content
- CodeFileName : `${question.difficulty}\\$!velocityTool.camelCaseName(${question.titleSlug}) `
- CodeTemplate :

```
package main

/**
 * @author : 禾几海
 * @date : $!velocityTool.date("yyyy年MM月dd日 hh:mm")
 * @difficulty : ${question.difficulty}
 * @info submissions: ${question.submissions}       accepted: ${question.accepted}      acceptance: $!velocityTool.percentage(${question.accepted},${question.submissions})
 * @see <a href="https://leetcode-cn.com/problems/${question.titleSlug}">${question.frontendQuestionId}.${question.title}</a>
 * @desc :
 */
 
${question.code}

func main() {
}
```

## 📒 刷题计划

-[x] 回溯算法
-[ ] 排序和搜索
-[ ] 动态规划
-[ ] 分治算法
-[ ] 贪心
-[ ] 并查集
-[ ] 图（最小生成树）
-[ ] KMP算法