## 使用注意点

对于FlexBox，为了大量地复用，可以选择用FlexBoxLayoutManager，来扩展RecyclerView，这个扩展的使用在flexbox-layout的dev_recyclerview分支下

使用button作为标签时，边框和内容之间的间距处理比较麻烦，使用TextView比较好

使用layoutMargin做为间距时，发现在android4.1机型上会有显示不全的问题

解决方案：使用外套FrameLayout加Padding的方式来实现RecyclerView item间距，而不是使用layoutMargin，因为这个属性（android4.1）会影响到flexbox

所以先弃用，转而使用hongyang的FlowLayout

## 参考

[Google发布flexbox-layout 能替代FlowLayout吗？](http://chuansong.me/n/400690651952)