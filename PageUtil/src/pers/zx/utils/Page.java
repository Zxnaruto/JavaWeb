package pers.zx.utils;

public class Page {
    // ҳ�����ڼ�ҳ��
    private int currentpage;

    // ��ѯ���ݿ������Ӧ�������ж�����
    private int total;// �����ݿ�鴦���ܼ�¼��

    // ÿҳ��ѯ��������
    private int size;

    // ��ҳ
    private int next;

    // ���һҳ
    private int last;
    
    private int lpage;
    
    private int rpage;
    
    //��������ʼ��
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
        //���������ʾ���÷�Nҳ���������������Nҳ�Ļ�����+1ҳ
        int totalPages = total%pagesize==0? total/pagesize : (total/pagesize)+1;
        
        //��ҳ��
        this.last = totalPages;
        
        //�жϵ�ǰҳ�Ƿ�Խ��,���Խ�磬���ǾͲ����һҳ
        if(currentpage>totalPages){
            this.currentpage = totalPages;
        }else{
            this.currentpage=currentpage;
        }
        if(currentpage<=0){
            this.currentpage=1;
        }
        
        //����start   1----0    2  ------ 5
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


    //��һҳ
    public int getUpper() {
        return currentpage>1? currentpage-1: currentpage;
    }

    public int getLast() {
        return last;
    }

    //�ܹ��ж���ҳ����ĩҳ
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
     * @param total   �ܼ�¼��
     * @param currentpage    ��ǰҳ
     * @param pagesize    ÿҳ��ʾ������
     */
    public Page(int total,int currentpage,int pagesize) {
        //�ܼ�¼��
        this.total = total;
        //ÿҳ��ʾ������ 
        this.size=pagesize;
        
        //���㵱ǰҳ�����ݿ��ѯ��ʼֵ�Լ���ҳ��
        setCurrentpage(currentpage, total, pagesize);
        
        //��ҳ����
        int leftcount =5,    //��Ҫ����һҳִ�ж��ٴ�
            rightcount =4;
        //���ҳ
        this.lpage =currentpage;
        //����ҳ
        this.rpage =currentpage;
        
        //2���ж�
        this.lpage = currentpage-leftcount;            //��������µ����
        this.rpage = currentpage+rightcount;        //��������µ��յ�
        
        //ҳ��=��ҳ���ͽ���ҳ�Ĳ�
        int topdiv = this.last-rpage;                //�ж��Ƿ�������ҳ��
        
        /***
         * ���ҳ
         * 1��ҳ��<0  ���ҳ=���ҳ+ҳ��ֵ
         * 2��ҳ��>=0 �����յ��ж�
         */   
        this.lpage=topdiv<0? this.lpage+topdiv:this.lpage;
        
        /***
         * ����ҳ
         * 1�����ҳ<=0   ����ҳ=|���ҳ|+1
         * 2�����ҳ>0    ����ҳ
         */
        this.rpage=this.lpage<=0? this.rpage+(this.lpage*-1)+1: this.rpage;
        
        /***
         * �����ҳ<=0  �����ҳΪ��һҳ
         * ���򲻹�
         */
        this.lpage=this.lpage<=0? 1:this.lpage;
        
        /***
         * �������ҳ>��ҳ��   ����ҳ=��ҳ�� 
         * ���򲻹�
         */
        this.rpage=this.rpage>last? this.last:this.rpage;
    }
    
    
    

    public int getStart() {
        return start;
    }
}
