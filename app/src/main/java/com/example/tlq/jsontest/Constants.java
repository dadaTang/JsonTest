package com.example.tlq.jsontest;

import android.os.Environment;

/**
 *
 * @author Hello
 * @date 2017/7/28
 */

public class Constants {
    public static final String FILE_ROOT_FOLDER = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final String FILE_CACHE_FOLDER = Environment.getExternalStorageDirectory().getAbsolutePath() + "/eInk/";
    public static final String FILE_UPDATE_CLIENT_SAVE_PATH = FILE_CACHE_FOLDER + "Clinet/xx_eink.apk";
    public static final String FILE_SLEEP_IMAGE_SAVE_PATH = FILE_ROOT_FOLDER+ "/sleep/sleeping.jpg";
    public static final String FILE_POWER_OFF_IMAGE_SAVE_PATH = FILE_ROOT_FOLDER+ "/poweroff/poweroff.jpg";
    public static final String CRASH_LOG_FOLDER = "eInk_crash";//异常日志文件夹
    public static final String IMAGE_FOLDER = "image/";
    public static final String NOTE_FOLDER = "note/";
    public static final String QUESTION_IMAGE_FOLDER = "question/";
    public static final String WEB_CACHE_FOLDER = "web_cache";

    public static String HTTP_COOKIE = "";
    public static String HTTP_API_VERSION = "";
    public static String HTTP_CLIENT_VERSION = "";
    public static String HTTP_TOKEN_ID = "";
    public static String HTTP_PASSWORD = "";
    public static String HTTP_IMEI = "";
    public static String HTTP_CLIENT_AGENT = "";
    public static String HTTP_CLIENT_HASH = "";

    public static String HTTP_STUDENT_ID = "";
    public static String HTTP_ACCOUNT_ID = "";
    public static String HTTP_LOGIN_STYLE= "";
    public static float DENSITY;
    public static int EXACT_SCREEN_WIDTH;
    public static int EXACT_SCREEN_HEIGHT;
    public static int COLUMN_BASE = 0;
    public static int CLIENT_TYPE = 7;//客户端类型
    public static final String REQUEST_INFO_TYPE = "request_info_type";
    public static final String DATE_FORMAT_STYLE_FIVE = "yyyy_MM_dd_HH_mm_ss";

    //开发环境
/*    public static String DEVELOPMENT_URL_API ="http://114.55.108.78:8081/client";
    public static String PRODUCTION_URL_WEBVIEW ="http://101.68.92.138:8003";*/
    //测试环境
    public static String TEST_REQUEST_URL = "http://112.74.167.122:8000/client";
    public static String TEST_WEB_URL = "http://112.74.167.122:8002";
    //现网环境
    public static String PRODUCT_REQUEST_URL = "http://112.74.141.244:8070/client";
    public static String PRODUCT_WEB_URL = "http://120.25.128.70:8003";

    /*  public static String ROOT_REQUEST_URL = TEST_REQUEST_URL;
        public static String ROOT_WEB_URL = TEST_WEB_URL;*/
    public static String ROOT_REQUEST_URL = PRODUCT_REQUEST_URL;
    public static String ROOT_WEB_URL = PRODUCT_WEB_URL;

    public static String NO_NETWORK_URL = "file:///android_asset/network/no_network.html";

    public static final String TASK_URL_GET_PROVINCE_CITY = "/api/common/getProvinceCity";//省市信息接口
    public static final String TASK_URL_GET_SCHOOL_LIST =  "/api/student/getSchoolList";//获取学校列表接口
    public static final String TASK_URL_GET_NETWORK_LOCATION = "http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json";//省市信息接口json
    public static final String TASK_URL_XX_LOGIN =  "/api/student/studentLogin";//向学登录
    public static final String TASK_URL_LOGIN =  "/api/einkUser/userLoginEink";//Eink登录
    public static final String TASK_URL_SUBMIT_QUESTION_PKG = "/api/einkStudent/submitQuestionPkg";
    public static final String TASK_URL_FILE_UPLOAD = "/api/common/fileUpload";
    public static final String TASK_URL_ADD_BOOKMARK = "/api/einkBook/addBookMark";
    public static final String TASK_URL_GET_NEW_CLIENT_INFO = "/api/common/getNewClientInfo";
    public static final String TASK_URL_GET_DEVICE_IMAGE_CONFIG = "/api/einkSys/getDeviceImgConf";

    public static class HttpData{
        public static final String WEB_DEFAULT_URL = "/#/home";
        public static final String WEB_REGISTER_URL = "/#/regist";
        public static final String WEB_QUESTION_URL = "/#/question/";
        public static final String WEB_ACCEPT_URL = "/#/userManual/";
    }

    public static class DB{
        public static final String DB_NAME = "EInk.db";
        public static final int DB_VERSION = 1;
        public static final String NOTE_INFO_TABLE = "note_info_table";
        public static final String TEMP_ANSWER_INFO_TABLE = "temp_answer_info_table";
        public static final String TEMP_REQUEST_INFO_TABLE = "temp_request_info_table";

        /** 商品信息结构表(GoodsInfo)*/
        public  static  final String DOWNLOAD_GOODS_INFO_TABLE="download_goods_info_table";
        /** 文件资源结构表(SourceFile) */
        public static final String SOURCE_FILE_TABLE = "source_file_table";
        /** 教辅章节信息(TeachingPkgBookChapterInfo) */
        public static final String TEACHING_PKG_BOOK_CHAPTER_INFO_TABLE = "teaching_pkg_book_chapter_info_table";
        /**教辅信息(TeachingPkgBookInfo)*/
        public static final String TEACHING_PKG_BOOK_INFO_TABLE = "teaching_pkg_book_info_table";
        /** 套题信息(TeachingPkgInfo)*/
        public static final String TEACHING_PKG_INFO_TABLE = "teaching_pkg_info_table";
        /**资源信息(TeachingResourceInfo)*/
        public static final String TEACHING_RESOURCE_INFO_TABLE = "teaching_resource_info_table";
        /**习题基础数据结构表(QuestionList) */
        public static final String QUESTION_LIST_TABLE = "question_list_table";
    }

    public static class IntentData{
        public static final String NOTE_INFO = "note_info";
        public static final String IMAGE_PATH = "image_path";
        public static final String INTENT_TYPE = "intent_type";
        public static final String QUESTION_ID = "question_id";
        public static final String QUESTION_IMAGE = "question_image";
        public static final String QUESTION_IS_SINGLE = "question_is_single";
        public static final String QUESTION_USER_ANSWER_IMAGE = "question_user_answer_image";
        public static final String QUESTION_USER_ANSWER_IMAGE_BASE64 = "question_user_answer_image_base64";
        public static final String QUESTION_EXTRA = "question_extra";
        public static final String QUESTION_DETAIL_URL = "question_detail_url";
        public static final String QUESTION_HEIGHT = "question_height";
    }

    public static class Action{
        public static final String REFRESH_DELETE_NOTE = "refresh_delete_note";
        public static final String REFRESH_NOTE_ADAPTER = "refresh_note_adapter";
        public static final String REFRESH_EDIT_NOTE = "refresh_edit_note";
        public static final String CALL_BACK_QUESTION = "call_back_question";
        public static final String ADD_BOOKMARK = "add_bookmark";
        public static final String NETWORK_CONNECT ="receiver_network_connect";
        public static final String NETWORK_DISCONNECT ="receiver_network_disconnect";

    }

    public static class TASK_TYPE {
        public static int GET_SCHOOL_LIST = COLUMN_BASE++;
        public static int GET_PROVINCE_CITY_TASK = COLUMN_BASE++;
        public static int GET_NETWORK_LOCATION_TASK = COLUMN_BASE++;
        public static int LOGIN_TASK = COLUMN_BASE++;
        public static int LOGIN_XX_TASK = COLUMN_BASE++;
        public static int FILE_UPLOAD_TASK = COLUMN_BASE++;
        public static int SUBMIT_QUESTION_PKG_TASK = COLUMN_BASE++;
        public static int ADD_BOOKMARK_TASK = COLUMN_BASE++;
        public static int GET_NEW_CLIENT_INFO = COLUMN_BASE++;
        public static int GET_DEVICE_IMAGE_CONFIG = COLUMN_BASE++;
    }
}
