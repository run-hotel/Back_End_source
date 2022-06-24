package com.air.airtest;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;

import com.air.airtest.entity.Customer;
import com.air.airtest.entity.Handel;
import com.air.airtest.entity.HotelStaff;
import com.air.airtest.entity.RoomInfo;
import com.air.airtest.entity.RoomOrderInfo;
import com.air.airtest.entity.RoomType;
import com.air.airtest.mapper.CustomerMapper;
import com.air.airtest.mapper.HandelOrderMapper;
import com.air.airtest.mapper.HotelStaffMapper;
import com.air.airtest.mapper.RoomMapper;
import com.air.airtest.mapper.RoomOrderMapper;
import com.air.airtest.mapper.RoomTypeMapper;
import com.air.airtest.vo.Hotelvo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
    public static void main(String[] args) throws ParseException {
        String resource = "mybatis-config.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = sqlSessionFactory.openSession()) {
                RoomMapper roommapper = session.getMapper(RoomMapper.class);
                // List<Hotelvo> roomInfo =  roommapper.selectRemainingRooms("001");
                // for(Hotelvo room : roomInfo){
                //     System.out.println(room);
                // }
                // // 所有用户信息
                // List<RoomInfo> roomInfo = roommapper.selectRoomInfo();
                // for(RoomInfo room : roomInfo){
                //     System.out.println(room);
                // }
                // int count = roommapper.updateRoomStatus("1003");
                // session.commit();
                // System.out.println(count);
                //查
                // String a = roommapper.selectRoomTypeNo("1001");
                // System.out.println(a);

                //  RoomOrderMapper o1 = session.getMapper(RoomOrderMapper.class);
                //  List<Hotelvo> roomInfo =  o1.salesVolumes();
                //  for(Hotelvo room : roomInfo){
                //     System.out.println(room);
                // }
                // SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
                // Date date1 = (Date) dateformat.parse("2016-6-19");
                // Date date2 = (Date) dateformat.parse("2016-6-20");
                // RoomOrderInfo order = new RoomOrderInfo();
                // order.setCustomerphone("12345678902");
                // order.setOrderno("099");
                // order.setOrderstatus(1);
                // order.setRoomtypename("danrenfan");
                // order.setInttime(date1);
                // order.setOuttime(date2);
                // int count = o1.addOrder(order);
                // session.commit();
                // System.out.println(count);
                // List<Hotelvo> ws = o1.selectRoomForPeople("1001");
                // for(Hotelvo room : ws){
                //     System.out.println(room);
                // }
                // RoomOrderInfo r1 = o1.selectRoomOrderone("007");
                // System.out.println(r1);
                // List<RoomOrderInfo> roomOrderInfo = o1.selectRoomOrderInfo();
                // for(RoomOrderInfo roomorder : roomOrderInfo){
                //     System.out.println(roomorder);
                // }
                // int count = o1.updateOrderStatus("007");
                // session.commit();
                // System.out.println(count);

                // RoomTypeMapper w1 = session.getMapper(RoomTypeMapper.class);
                // String a = w1.selectRoomTypeNoforRoomType("单人房");
                // System.out.println(a);
                // List<RoomType> roomInfo = w1.selectRoomType();
                // for(RoomType room : roomInfo){
                //     System.out.println(room);
                // }
                // int count = w1.updateRoomPrice((float) 100.0, "001");
                // session.commit();
                // System.out.println(count);
                // int count = w1.updateRoomNumber("003");
                // session.commit();
                // 
                //  CustomerMapper roommapper = session.getMapper(CustomerMapper.class);
                //  int a = roommapper.updateCustomerInfo("1", "zhouhwewewewe", "1233455", "1");
                 // // Customer customer = roommapper.getInfo("12345678904");
                // // System.out.println(customer);
                // int count = roommapper.updateCustomerInfo();
                //  session.commit();
                //  System.out.println(a);

                // Handel h1 = new Handel();
                // h1.setHotelstaffno("JD002");
                // h1.setOrderno("011");
                // h1.setRoomno("1003");
                // // Date da = new Date(2021-06-28);
                // // h1.setHandeldate(da);
                // // <!-- //'JD002','011','1003','2021-06-28' -->

                // HandelOrderMapper o1 = session.getMapper(HandelOrderMapper.class);
                // List<Hotelvo> as = o1.selectHandelOrder("12345");
                //  for(Hotelvo room : as){
                //     System.out.println(room);
                // }
                //String wi = o1.selectHandelRoomNo("004");
                //System.out.println(wi);

                // int count = o1.insertHandel(h1);
                // session.commit();
                //  if(count == 1){
                //     System.out.println("用户添加成功");
                // }else{
                //     System.out.println("用户添加失败");
                // }
                // System.out.println("12345");
                // HotelStaffMapper H1 = session.getMapper(HotelStaffMapper.class);
                // String h2 = "JD001";
                // HotelStaff h1 = H1.selectHotelStaff(h2);
                // System.out.println(h1);

            }
        } catch (IOException e) { 
            e.printStackTrace();
        }
    }
}