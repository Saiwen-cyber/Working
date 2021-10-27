# java实现画图

页面![1635323441258](C:\Users\admin\AppData\Local\Temp\1635323441258.png)

**drawboard类（菜单类 JFrame实现）**

​     将图形按钮排列好，存到button[i]中，根据MouseEvent4显示在下方确定currentchoice来调用相应图形方法。

**drawarea类（画板 JPanel实现）**

​    绘制好组件，使用mouseevent监控鼠标位置和操作，实时显示在下方

**shape类**

​      使用Graphics2D类绘图，调用现成方法

​        