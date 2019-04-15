package com.atguigu.demo.excel.easyexcel;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.Table;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.atguigu.crud.util.NumberUtils;
import com.atguigu.demo.excel.easyexcel.model.ExcelPropertyIndexModel;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author lhh
 * @date 2019/4/15 9:49
 * @Description: easyexcel操作事例
 */
public class WriteExcelDemo {
    Logger logger = LoggerFactory.getLogger(getClass());

    //写入操作
    @Test
    public void writeCase() throws FileNotFoundException {
        //OutputStream out = new FileOutputStream("withHead.xlsx");
        //OutputStream out = new FileOutputStream("src/main/webapp/sql/excel/withHead.xlsx");
        String imageName = NumberUtils.getImageName();
        OutputStream out = new FileOutputStream("src/main/webapp/sql/excel/withHead" + imageName + ".xlsx");
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
        Sheet sheet1 = new Sheet(1, 0);
        sheet1.setSheetName("sheet1");
        List<List<String>> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            List<String> item = new ArrayList<>();
            item.add("item0" + i);
            item.add("item1" + i);
            item.add("item2" + i);
            data.add(item);
        }
        List<List<String>> head = new ArrayList<List<String>>();
        List<String> headCoulumn1 = new ArrayList<String>();
        List<String> headCoulumn2 = new ArrayList<String>();
        List<String> headCoulumn3 = new ArrayList<String>();
        headCoulumn1.add("第一列");
        headCoulumn2.add("第二列");
        headCoulumn3.add("第三列");
        head.add(headCoulumn1);
        head.add(headCoulumn2);
        head.add(headCoulumn3);
        Table table = new Table(1);
        table.setHead(head);
        writer.write0(data, sheet1, table);
        writer.finish();
        System.out.println("导出成功!" + imageName + ".xlsx");
    }


    //定义实体类导出
    @Test
    public void writeModelCase() throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        String imageName = NumberUtils.getImageName();
        OutputStream out = new FileOutputStream("src/main/webapp/sql/excel/withBeanHead" + imageName + ".xlsx");
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
        Sheet sheet1 = new Sheet(1, 0, ExcelPropertyIndexModel.class);
        sheet1.setSheetName("sheet1");
        List<ExcelPropertyIndexModel> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ExcelPropertyIndexModel item = new ExcelPropertyIndexModel();
            item.name = "name" + i;
            item.age = "age" + i;
            item.email = "email" + i;
            item.address = "address" + i;
            item.sax = "sax" + i;
            item.heigh = "heigh" + i;
            item.last = "last" + i;
            data.add(item);
        }
        writer.write(data, sheet1);
        writer.finish();
        long endTime = System.currentTimeMillis();

        System.out.println("导出成功!:" + imageName + ".xlsx");
        logger.info("导出成功!:{}.xlsx,用时：{}毫秒", imageName, (endTime - startTime));
    }

}
