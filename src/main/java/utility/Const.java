package utility;

public class Const {
    // JSP PAGES
    public static final String LOGIN_PAGE = "/jsp/Login.jsp";
    public static final String SIGNUP_PAGE = "/jsp/Signup.jsp";
    public static final String MAIN_PAGE = "/jsp/Main.jsp";
    public static final String BASKET_PAGE = "/jsp/Basket.jsp";
    public static final String ADD_BOOK_PAGE = "/jsp/AddBook.jsp";
    public static final String PROFILE_PAGE = "/jsp/Profile.jsp";
    public static final String ORDER_PAGE = "/jsp/Order.jsp";
    public static final String ADDRESS_PAGE = "/jsp/Address.jsp";

    // FIELDS
    public static final String USER = "user";
    public static final String NAME = "name";
    public static final String BRIEF_INFO = "briefInfo";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "lastName";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";
    public static final String PASSWORD = "password";
    public static final String NEW_PASSWORD = "new_password";
    public static final String CONFIRM_PASSWORD = "confirm_password";
    public static final String COST = "cost";
    public static final String AMOUNT = "amount";
    public static final String URL = "url";
    public static final String BOOKS = "books";
    public static final String USER_ID = "User_idUser";
    public static final String BOOK_ID = "Book_idBook";
    public static final String BOUGHT = "bought";
    public static final String BASKET_ITEMS = "basketItems";
    public static final String ORDER_ITEMS = "orderItems";
    public static final String OPERATION = "operation";
    public static final String OPERATION_REMOVE = "Remove";
    public static final String OPERATION_BUY = "Buy";
    public static final String OPERATION_ADD_BOOK_BASKET = "add_book_basket";
    public static final String OPERATION_SEARCH = "search";
    public static final String OPERATION_CHANGE_PASSWORD = "Change password";
    public static final String OPERATION_UPDATE = "Update";
    public static final String SEARCH_BAR_PARAM = "search_bar";
    public static final String BOOK_ID_PARAM = "book_id";
    public static final String DATABASE_BOOK_ID = "idBook";
    public static final String CITY = "city";
    public static final String STREET = "street";
    public static final String NUMBER_HOME = "number_home";
    public static final String ERROR = "error";
    public static final String LANG = "lang";
    public static final String AMOUNT_CHANGE = "amountChange";





    // DATABASE QUERIES
    public static final String GET_USER_BY_EMAIL = "Select * from User where email=?";
    public static final String INSERT_USER = "insert into user(firstName,lastName,email,password,phoneNumber) values (?,?,?,?,?)";
    public static final String INSERT_BOOK_WITH_URL = "INSERT INTO BOOK(name,cost,url,briefInfo,amount) VALUES (?,?,?,?,?)";
    public static final String INSERT_BOOK = "INSERT INTO BOOK(name,cost,briefInfo,amount) VALUES (?,?,?,?)";
    public static final String GET_BOOKS = "SELECT * FROM BOOK";
    public static final String GET_BOOK_LIKE ="SELECT * FROM BOOK WHERE NAME LIKE ?";
    public static final String GET_BOOK_BY_ID = "SELECT * FROM BOOK WHERE idBook=";
    public static final String GET_BASKET_ITEMS = "SELECT * FROM BASKET WHERE User_idUser=? and Bought = 0";
    public static final String UPDATE_USER_INFO = "update user set firstName=?, lastName=?, phoneNumber=? where email = ?";
    public static final String UPDATE_USER_PASSWORD = "update user set password = ? where email = ?";
    public static final String DELETE_BASKET_ITEM ="delete from basket where Book_idBook = ? and User_idUser = ?";
    public static final String UPDATE_BASKET_ITEMS = "update basket set Bought = 1 where User_idUser=?";
    public static final String GET_ORDER_ITEMS = "SELECT * FROM BASKET WHERE User_idUser=? and Bought = 1";
    public static final String INSERT_BASKET_ITEM = "Insert into basket(User_idUser,Book_idBook) values(?,?)";
    public static final String GET_BASKET_ITEM = "Select * from basket where User_idUser=? and Book_idBook=?";
    public static final String UPDATE_BASKET_ITEM = "update basket set amount=? where Book_idBook = ? and User_idUser = ?";
    public static final String INSERT_ADDRESS = "insert into address(city,street,numHouse,User_idUser) values(?,?,?,?)";

    // ROUTES

    public static final String MAIN = "/main";
    public static final String LOGIN = "/login";
    public static final String ORDER = "/orders";
    public static final String BASKET = "/basket";
    public static final String PROFILE = "/profile";
    public static final String SIGN_UP = "/signup";
    public static final String ADDRESS = "/address";
    //Error messages

    public static final String LOGIN_ERROR = "Invalid LoginId Or Password";
    public static final String EMAIL_ERROR = "Please provide valid email";
    public static final String EMPTY_ERROR = "Do not leave fields empty";

}
