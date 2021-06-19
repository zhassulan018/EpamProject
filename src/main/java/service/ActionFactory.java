package service;

import java.util.HashMap;
import java.util.Map;
import static utility.Const.*;

public class ActionFactory {
    private final Map<String, Service> map = new HashMap<>();

    {
        map.put(MAIN, new BookService());
        map.put(ADD_BOOK, new AddBookService());
        map.put(ADDRESS, new AddressService());
        map.put(BASKET, new BasketService());
        map.put(LANGUAGE, new LanguageService());
        map.put(LOGIN, new LogInService());
        map.put(LOGOUT, new LogoutService());
        map.put(ORDER,new OrderService());
        map.put(PROFILE,new ProfileService());
        map.put(SIGN_UP,new SignUpService());
    }

    public Service getActionPath(String url){
        Service service = null;
        for (Map.Entry<String, Service> mp : map.entrySet()) {
            if (url.equals(mp.getKey())) {
                service = map.get(mp.getKey());
            }
        }

        return service;
    }


}
