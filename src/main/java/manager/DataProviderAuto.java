package manager;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//public class DataProviderCar {

//    @DataProvider
//    public Iterator<Object[]> contactCSV() throws IOException {
//        List<Object[]> list=new ArrayList<>();
//        BufferedReader reader=new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
//        String line = reader.readLine();
//
//        while (line!=null){
//            String[] all=line.split(",");
//            list.add(new Object[]{Contacts.builder()
//                    .name(all[0])
//                    .lastname(all[1])
//                    .email(all[2])
//                    .phoneNumber(all[3])
//                    .address(all[4])
//                    .description(all[5])
//                    .build()});
//            line= reader.readLine();
//        }
//}
