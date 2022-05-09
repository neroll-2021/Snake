# Snake
用java和javaFX制作的贪吃蛇小游戏

本程序使用了MVC设计模式，将程序分为视图、控制器、模型三部分，分别在view、controller、model文件夹中。

view中用来展示游戏窗口，controller将监听到的键盘事件传递给model，model作出反应。

只实现了贪吃蛇的基本操作，界面也很简单

------------------------------------

一直都想着写一个程序来熟悉一下java，上网搜了许多java的课程设计，很多都要求要做图形界面，无奈只能去学点GUI。学了一些基本知识后，突然想到了贪吃蛇，
于是花了三天时间做出了这个游戏，算是圆了学C语言时的梦。

其实最难的不是如何实现贪吃蛇的基本功能（移动、转弯、吃食物、判断死亡），而是对类的设计。一开始理念不清就开始写代码，写着写着发现写不下去了，
然后用UML图画出整个程序主要的类以及它们之间的关系，整个思路就清晰了，改了架构后写起来就很顺利。

第一次接触MVC模式，试着照着样子写，肯定会有不足之处，等以后代码写多了肯定会对设计模式有更深的理解。