package com.icei.domain;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.List;

public class BrandGoods {

    private Integer goodsId;//id
    private Integer brandId;//品牌ID
    @Excel(name = "商品名称",width = 20,orderNum = "3")
    private String goodsName;//名称
    private Integer typeDetailId;//具体类型
    private Float goodsPrice;//基础价格
    private Float goodsDiscount;//商品折扣
    private Float diyPrice;//定制收费
    private Integer isDiy;//是否定制
    private Integer productionCycle;//生产周期，单位：天
    private String goodsDec;//商品描述
    private String materials;//材质
    private Integer salesVolume;//销量
    private Float goodsQuality;//商品评价
    private Float serverAttitude;//服务评价
    private Integer assessCountLove;//商品满意度
    private Integer assessCount;//评价总人数
    private Integer likeCount;//收藏总数
    private String diyBack;//定制模型img
    private String goodsImg;//商品展示图片
    private List<GoodsMedia> goodsMedia;//图片
    private GoodsType goodsType;//商品种类
    private GoodsTypeDetail goodsTypeDetail;//详细类型
    private List<GoodsSize> goodsSize;//尺寸
    private Brand brand;//商品店铺
    private GoodsMedia goodsMediaOne;//只获取商品的一张图片

    public Integer getGoodsId() {
        return goodsId;
    }
    public GoodsType getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(GoodsType goodsType) {
		this.goodsType = goodsType;
	}
	public GoodsMedia getGoodsMediaOne() {
		return goodsMediaOne;
	}
	public void setGoodsMediaOne(GoodsMedia goodsMediaOne) {
		this.goodsMediaOne = goodsMediaOne;
	}
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
    public Integer getBrandId() {
        return brandId;
    }
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
    public String getGoodsName() {
        return goodsName;
    }
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
    public Integer getTypeDetailId() {
        return typeDetailId;
    }
    public void setTypeDetailId(Integer typeDetailId) {
        this.typeDetailId = typeDetailId;
    }
    public Float getGoodsPrice() {
        return goodsPrice;
    }
    public void setGoodsPrice(Float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
    public Float getGoodsDiscount() { return goodsDiscount; }
    public void setGoodsDiscount(Float goodsDiscount) {
        this.goodsDiscount = goodsDiscount;
    }
    public Float getDiyPrice() {
        return diyPrice;
    }
    public void setDiyPrice(Float diyPrice) {
        this.diyPrice = diyPrice;
    }
    public Integer getIsDiy() {
        return isDiy;
    }
    public void setIsDiy(Integer isDiy) {
        this.isDiy = isDiy;
    }
    public Integer getProductionCycle() {
        return productionCycle;
    }
    public void setProductionCycle(Integer productionCycle) {
        this.productionCycle = productionCycle;
    }
    public String getGoodsDec() {
        return goodsDec;
    }
    public void setGoodsDec(String goodsDec) {
        this.goodsDec = goodsDec;
    }
    public String getMaterials() {
        return materials;
    }
    public void setMaterials(String materials) {
        this.materials = materials;
    }
    public Integer getSalesVolume() {
        return salesVolume;
    }
    public void setSalesVolume(Integer salesVolume) {
        this.salesVolume = salesVolume;
    }
    public Float getGoodsQuality() {
        return goodsQuality;
    }
    public void setGoodsQuality(Float goodsQuality) {
        this.goodsQuality = goodsQuality;
    }
    public Float getServerAttitude() {
        return serverAttitude;
    }
    public void setServerAttitude(Float serverAttitude) {
        this.serverAttitude = serverAttitude;
    }
    public Integer getAssessCountLove() {
        return assessCountLove;
    }
    public void setAssessCountLove(Integer assessCountLove) {
        this.assessCountLove = assessCountLove;
    }
    public Integer getAssessCount() {
        return assessCount;
    }
    public void setAssessCount(Integer assessCount) {
        this.assessCount = assessCount;
    }
    public Integer getLikeCount() {
        return likeCount;
    }
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }
    public String getDiyBack() {
        return diyBack;
    }
    public void setDiyBack(String diyBack) {
        this.diyBack = diyBack;
    }
    public String getGoodsImg() {
        return goodsImg;
    }
    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }
	public List<GoodsSize> getGoodsSize() {
		return goodsSize;
	}
	public void setGoodsSize(List<GoodsSize> goodsSize) {
		this.goodsSize = goodsSize;
	}
	public GoodsTypeDetail getGoodsTypeDetail() {
		return goodsTypeDetail;
	}
	public void setGoodsTypeDetail(GoodsTypeDetail goodsTypeDetail) {
		this.goodsTypeDetail = goodsTypeDetail;
	}
    public void setGoodsMedia(List<GoodsMedia> goodsMedia) {
        this.goodsMedia = goodsMedia;
    }
    public List<GoodsMedia> getGoodsMedia() {
        return goodsMedia;
    }
    public GoodsMedia getGoodsMeadiaOne() {
        return goodsMediaOne;
    }
    public void setGoodsMeadiaOne(GoodsMedia goodsMeadiaOne) {
        this.goodsMediaOne = goodsMeadiaOne;
    }
    public Brand getBrand() {
        return brand;
    }
    public void setBrand(Brand brand) {
        this.brand = brand;
    }
    /**
     * toStirng方法打印json
     * @return
     */
    @Override
    public String toString() {
        return "BrandGoods{" +
                "goodsId=" + goodsId +
                ", brandId=" + brandId +
                ", goodsName='" + goodsName + '\'' +
                ", typeDetailId=" + typeDetailId +
                ", goodsPrice=" + goodsPrice +
                ", goodsDiscount=" + goodsDiscount +
                ", diyPrice=" + diyPrice +
                ", isDiy=" + isDiy +
                ", productionCycle=" + productionCycle +
                ", goodsDec='" + goodsDec + '\'' +
                ", materials='" + materials + '\'' +
                ", salesVolume=" + salesVolume +
                ", goodsQuality=" + goodsQuality +
                ", serverAttitude=" + serverAttitude +
                ", assessCountLove=" + assessCountLove +
                ", assessCount=" + assessCount +
                ", likeCount=" + likeCount +
                ", diyBack='" + diyBack + '\'' +
                ", goodsImg='" + goodsImg + '\'' +
                ", goodsMedia=" + goodsMedia +
                ", goodsType=" + goodsType +
                ", goodsTypeDetail=" + goodsTypeDetail +
                ", goodsSize=" + goodsSize +
                ", brand=" + brand +
                ", goodsMediaOne=" + goodsMediaOne +
                '}';
    }
}