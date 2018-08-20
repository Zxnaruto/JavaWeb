package pers.zx.utils;

public class Page {
    // 页数（第几页）
    private int currentpage;

    // 查询数据库里面对应的数据有多少条
    private int total;// 从数据库查处的总记录数

    // 每页查询的数量条
    private int size;

    // 下页
    private int next;

    // 最后一页
    private int last;
    
    private int lpage;
    
    private int rpage;
    
    //从哪条开始查
    private int start;
    
    public Page() {
        super();
    }

    public int getCurrentpage() {
        return currentpage;
    }

    /****
     * 
     * @param currentpage
     * @param total
     * @param pagesize
     */
    public void setCurrentpage(int currentpage,int total,int pagesize) {
        //如果整除表示正好分N页，如果不能整除在N页的基础上+1页
        int totalPages = total%pagesize==0? total/pagesize : (total/pagesize)+1;
        
        //总页数
        this.last = totalPages;
        
        //判断当前页是否越界,如果越界，我们就查最后一页
        if(currentpage>totalPages){
            this.currentpage = totalPages;
        }else{
            this.currentpage=currentpage;
        }
        if(currentpage<=0){
            this.currentpage=1;
        }
        
        //计算start   1----0    2  ------ 5
        this.start = (this.currentpage-1)*pagesize;
        
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNext() {
        return  currentpage<last? currentpage+1: last;
    }


    //上一页
    public int getUpper() {
        return currentpage>1? currentpage-1: currentpage;
    }

    public int getLast() {
        return last;
    }

    //总共有多少页，即末页
    public void setLast(int last) {
        this.last = total%size==0? total/size : (total/size)+1;
    }
    

    public int getLpage() {
        return lpage;
    }

    public void setLpage(int lpage) {
        this.lpage = lpage;
    }

    public int getRpage() {
        return rpage;
    }

    public void setRpage(int rpage) {
        this.rpage = rpage;
    }

    /****
     * 
     * @param total   总记录数
     * @param currentpage    当前页
     * @param pagesize    每页显示多少条
     */
    public Page(int total,int currentpage,int pagesize) {
        //总记录数
        this.total = total;
        //每页显示多少条 
        this.size=pagesize;
        
        //计算当前页和数据库查询起始值以及总页数
        setCurrentpage(currentpage, total, pagesize);
        
        //分页计算
        int leftcount =5,    //需要向上一页执行多少次
            rightcount =4;
        //起点页
        this.lpage =currentpage;
        //结束页
        this.rpage =currentpage;
        
        //2点判断
        this.lpage = currentpage-leftcount;            //正常情况下的起点
        this.rpage = currentpage+rightcount;        //正常情况下的终点
        
        //页差=总页数和结束页的差
        int topdiv = this.last-rpage;                //判断是否大于最大页数
        
        /***
         * 起点页
         * 1、页差<0  起点页=起点页+页差值
         * 2、页差>=0 起点和终点判断
         */   
        this.lpage=topdiv<0? this.lpage+topdiv:this.lpage;
        
        /***
         * 结束页
         * 1、起点页<=0   结束页=|起点页|+1
         * 2、起点页>0    结束页
         */
        this.rpage=this.lpage<=0? this.rpage+(this.lpage*-1)+1: this.rpage;
        
        /***
         * 当起点页<=0  让起点页为第一页
         * 否则不管
         */
        this.lpage=this.lpage<=0? 1:this.lpage;
        
        /***
         * 如果结束页>总页数   结束页=总页数 
         * 否则不管
         */
        this.rpage=this.rpage>last? this.last:this.rpage;
    }
    
    
    

    public int getStart() {
        return start;
    }
}
