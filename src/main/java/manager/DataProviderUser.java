package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderUser {
    @DataProvider
    public Iterator<Object[]> example(){
        List<Object[]> list=new ArrayList<>();



        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> loginData(){
        List<Object[]> list=new ArrayList<>();
        list.add(new Object[]{"sonicboom@gmail.com","Snow123456!"});
        list.add(new Object[]{"sonicboom@gmail.com","Snow123456!"});
        list.add(new Object[]{"sonicboom@gmail.com","Snow123456!"});


        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> loginModel(){
        List<Object[]> list=new ArrayList<>();
        list.add(new Object[]{new User().setEmail("sonicboom@gmail.com").setPassword("Snow123456!")});
        list.add(new Object[]{new User().setEmail("sonicboom@gmail.com").setPassword("Snow123456!")});
        list.add(new Object[]{new User().setEmail("sonicboom@gmail.com").setPassword("Snow123456!")});



        return list.iterator();
    }
}
