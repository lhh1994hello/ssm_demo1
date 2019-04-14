package com.atguigu.demo.excel;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lhh
 * @Date: 2019/4/14 23:12
 * @Version 1.0
 * 阿里巴巴excel导入，导出测试
 */
@SuppressWarnings("all")
public class EasyExcelDemo {
    @Test
    public void fun1() {

    }

    public static void main(String[] args) {
        long act = System.currentTimeMillis();
        String filepath = "H:/1.xlsx";

        List<String> sheetContent = read(filepath);
        //write();
        System.out.println("一共" + sheetContent.size() + "有效数据");
        long end = System.currentTimeMillis();
        System.out.println("耗时间=======:" + (end - act) + "毫秒");

        // System.out.println(listUser.size());
    }

    //读取excel中数据
    private static List<String> read(String filepath) {
        final List<String> sheetContent = new ArrayList<>();
        try (
                InputStream inputStream = new FileInputStream(filepath)) { ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, new AnalysisEventListener<List<String>>() {

                        @Override
                        public void invoke(List<String> object, AnalysisContext context) {
                            //自行添加syl 》》》
                            StringBuffer stringBuffer = new StringBuffer();
                            if (object != null && !StringUtils.isEmpty(object.get(0))) {
                                for (String s : object) {
                                    if (null != s) {
                                        stringBuffer.append(s + "=");
                                    }
                                }
                                System.out.println("行==" + context.getCurrentRowNum() + ":  " + stringBuffer.toString());
                                sheetContent.add(stringBuffer.toString());
                                // 《《《自行添加结束
                                System.out.println("当前sheet:" + context.getCurrentSheet().getSheetNo() + ",当前行:" + context.getCurrentRowNum());
                            }

                        }

                        @Override
                        public void doAfterAllAnalysed(AnalysisContext context) {

                        }
                    });
            excelReader.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sheetContent;
    }
    private static List<String> read2(String filepath) {
        final List<String> sheetContent = new ArrayList<>();
        try (InputStream inputStream = new FileInputStream(filepath)) {

            ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, new AnalysisEventListener<List<String>>() {

            @Override
            public void invoke(List<String> object, AnalysisContext context) {
                //自行添加syl 》》》
                StringBuffer stringBuffer = new StringBuffer();
                if (object != null && !StringUtils.isEmpty(object.get(0))) {
                    for (String s : object) {
                        if (null != s) {
                            stringBuffer.append(s + "=");
                        }
                    }
                    System.out.println("行==" + context.getCurrentRowNum() + ":  " + stringBuffer.toString());
                    sheetContent.add(stringBuffer.toString());
                    // 《《《自行添加结束
                    System.out.println("当前sheet:" + context.getCurrentSheet().getSheetNo() + ",当前行:" + context.getCurrentRowNum());
                }

            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {

            }
        });
            excelReader.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sheetContent;
    }
}
