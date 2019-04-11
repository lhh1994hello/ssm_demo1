package com.atguigu.common.mybatis.bean;

/**
 * @author lhh
 * @date 2019/4/11 17:11
 * @Description:
 */
public class MyStudent {
    private Integer sno;
    private String sname;
    private String ssex;
    private int sage;
    private String sdept;

    public Integer getSno() {
        return sno;
    }

    public void setSno(Integer sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSdept() {
        return sdept;
    }

    public void setSdept(String sdept) {
        this.sdept = sdept;
    }

    @Override
    public String toString() {
        return "MyStudent{" +
                "sno=" + sno +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sage=" + sage +
                ", sdept='" + sdept + '\'' +
                '}';
    }
}
