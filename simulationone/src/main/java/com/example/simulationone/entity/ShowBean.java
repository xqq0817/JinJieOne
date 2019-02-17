package com.example.simulationone.entity;

import java.util.List;

public class ShowBean  {

    /**
     * result : [{"commodityId":81,"commodityName":"冬季新款 松紧腰灯笼袖蕾丝裙假两件连衣裙","masterPic":"http://172.17.8.100/images/small/commodity/nz/qz/3/1.jpg","price":418,"saleNum":0},{"commodityId":85,"commodityName":"秋冬女装新款长袖连衣裙女中长款气质打底毛衣裙鱼尾显瘦内搭裙韩版时尚宽松针织裙","masterPic":"http://172.17.8.100/images/small/commodity/nz/qz/7/1.jpg","price":99,"saleNum":0},{"commodityId":80,"commodityName":"秋季新款韩版女装连衣裙春秋冬学院风气质休闲时尚显瘦字母印花拼接荷叶边短裙子长袖连衣裙","masterPic":"http://172.17.8.100/images/small/commodity/nz/qz/2/1.jpg","price":178,"saleNum":0},{"commodityId":83,"commodityName":"秋季新款韩版女装淑女风荷叶边短款长袖连衣裙","masterPic":"http://172.17.8.100/images/small/commodity/nz/qz/5/1.jpg","price":168,"saleNum":0},{"commodityId":79,"commodityName":"冬新款女款连衣裙 V领纯色中长裙时尚百搭不对称连衣裙","masterPic":"http://172.17.8.100/images/small/commodity/nz/qz/1/1.jpg","price":148,"saleNum":0}]
     * message : 查询成功
     * status : 0000
     */

    public String message;
    public String status;
    public List<ResultBean> data;

    public class ResultBean {
        /**
         * commodityId : 81
         * commodityName : 冬季新款 松紧腰灯笼袖蕾丝裙假两件连衣裙
         * masterPic : http://172.17.8.100/images/small/commodity/nz/qz/3/1.jpg
         * price : 418
         * saleNum : 0
         */
        public int commodityId;
        public String commodityName;
        public String masterPic;
        public int price;
        public int saleNum;
    }
}
