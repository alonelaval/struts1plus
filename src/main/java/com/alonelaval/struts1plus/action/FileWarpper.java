package com.alonelaval.struts1plus.action;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Purpose:
 * 
 * @see	    
 * @since   1.1.0
 */
public class FileWarpper{
        private File file;
        private String fileType;
        
        
        public FileWarpper()
        {
            super();
        }
        public FileWarpper(File file, String fileType)
        {
            super();
            this.file = file;
            if(fileType != null &&  !fileType.isEmpty())
                this.fileType = fileTypes.get(fileType.toLowerCase());
            else
                this.fileType = fileType;
            
        }
        public File getFile()
        {
            return file;
        }
        public void setFile(File file)
        {
            this.file = file;
        }
        public String getFileType()
        {
            return fileType;
        }
        public void setFileType(String fileType)
        {
            this.fileType = fileType;
        }
        
        private static Map<String, String> fileTypes= new HashMap<String, String>();
        static{
            fileTypes.put("bmp", "image/bmp");
            fileTypes.put("gif", "image/gif");
            fileTypes.put("jpeg", "image/jpeg");
            fileTypes.put("tiff", "image/tiff");
            fileTypes.put("png", "image/png");
            fileTypes.put("pdf", "application/pdf");
            fileTypes.put("doc", "application/msword");
            fileTypes.put("xls", "application/vnd.ms-excel");
            fileTypes.put("ppt", "application/ms-powerpoint");
            fileTypes.put("txt", "text/plain");
            fileTypes.put("zip", "application/zip");
            /**
             * "application/vnd.openxmlformats-officedocument.wordprocessingml.document" (for .docx files)
            "application/vnd.openxmlformats-officedocument.wordprocessingml.template" (for .dotx files)
            "application/vnd.openxmlformats-officedocument.presentationml.presentation" (for .pptx files)
            "application/vnd.openxmlformats-officedocument.presentationml.slideshow" (for .ppsx files)
            "application/vnd.openxmlformats-officedocument.presentationml.template" (for .potx files)
            "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" (for .xlsx files)
            "application/vnd.openxmlformats-officedocument.spreadsheetml.template" (for .xltx files)
             * 
             */
        }
}


/**
 * $Log: FileWarpper.java,v $
 * 
 * @version 1.0 2015-1-29 
 *
 */