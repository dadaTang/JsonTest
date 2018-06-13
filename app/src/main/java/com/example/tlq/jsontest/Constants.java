package com.example.tlq.jsontest;

import android.os.Environment;

/**
 *
 * @author tlq
 * @date 2017/7/28
 */

public class Constants {
    public static final String FILE_ROOT_FOLDER = Environment.getExternalStorageDirectory().getAbsolutePath();
    public static final String FILE_CACHE_FOLDER = Environment.getExternalStorageDirectory().getAbsolutePath() + "/test/";

  

  
    public static class DB{
        public static final String DB_NAME = "test.db";
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

}
