package com.example.chen.easygo.utils;

import android.annotation.SuppressLint;
import android.util.Log;

import java.sql.Date;
import java.text.SimpleDateFormat;

 /**
 * Logͳһ������
 * @author wen
 * @version 2015��1��16��
 * @see L
 * @since
 */
@SuppressLint("SimpleDateFormat")
public class L
{
    
    
    public final static int VERBOSE = 5; //������������е�����Ϣ ���� VERBOSE��DEBUG��INFO��WARN��ERROR 

	public final static int DEBUG = 4; //debug�����������DEBUG��INFO��WARN��ERROR������Ϣ 
  
	public final static int INFO = 3; //info�����������INFO��WARN��ERROR������Ϣ 

	public final static int WARN = 2; //waring�����������WARN��ERROR������Ϣ 
	
	public final static int ERROR = 1;  //error��������ֻ���ERROR������Ϣ 
	
	

	public static int level = INFO;
	
    
    private static final String TAG = "wen";
    private static final String TAG_TS = "debug";
    //private static final String TAG = _CLASS_FUNC();
    public static final String SEPARATOR = ",";
    
    // ������Ĭ��tag�ĺ���
    public static void v(String msg)
    {
        if (VERBOSE>=level)
            Log.v(TAG, msg);
    }
    
    public static void d(String msg)
    {
    	if (DEBUG>=level)
            Log.d(TAG_TS, msg);
    }
    
    public static void i(String msg)
    {
    	if (INFO>=level)
            Log.i(TAG, msg);
    }
    
    public static void w(String msg)
    {
    	if (WARN>=level)
            Log.w(TAG, msg);
    }
    
    public static void e(String msg)
    {
    	if (ERROR>=level)
            Log.e(TAG, msg);
    }
    
    // �����Ǵ����Զ���tag�ĺ���
    public static void v(String tag, String msg)
    {
    	  if (VERBOSE>=level)
            Log.v(tag, msg);
    }
    
    public static void d(String tag, String msg)
    {
    	if (DEBUG>=level)
            Log.d(tag, msg);
    }
    
    public static void i(String tag, String msg)
    {
    	if (INFO>=level)
            Log.i(tag, msg);
    }
    
    public static void w(String tag, String msg)
    {
    	if (WARN>=level)
            Log.w(tag, msg);
    }
    
    public static void e(String tag, String msg)
    {
    	if (ERROR>=level)
            Log.e(tag, msg);
    }
    
    
    
    // ��ǰ�ļ���
    public static String _FILE_() {
    StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
    return traceElement.getFileName();
    }
    
    // ��ǰ����
    public static String _CLASS_() {
    StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
    return traceElement.getClassName();
    }
 
    // ��ǰ������
    public static String _FUNC_() {
    StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
    return traceElement.getMethodName();
    }
 
    // ��ǰ�к�
    public static int _LINE_() {
    StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
    return traceElement.getLineNumber();
    }
 
    // ��ǰʱ��
    public static String _TIME_() {
    Date now = new Date(0);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    return sdf.format(now);
 
    }
    
    public   static String _CLASS_FUNC(){
    	StackTraceElement traceElement = ((new Exception()).getStackTrace())[1];
        return traceElement.getClassName()+","+traceElement.getMethodName();
    }
    
    
    
    /**
     * �����־������Ϣ
     */
    public static String getLogInfo(StackTraceElement stackTraceElement)
    {
        StringBuilder logInfoStringBuilder = new StringBuilder();
        
        // ��ȡ�ļ���.��xxx.java
        String fileName = stackTraceElement.getFileName();
        // ��ȡ����.������+����
        String className = stackTraceElement.getClassName();
        // ��ȡ�������
        String methodName = stackTraceElement.getMethodName();
        // ��ȡ�����������
        int lineNumber = stackTraceElement.getLineNumber();
        
        logInfoStringBuilder.append("[ ");
        
        logInfoStringBuilder.append("fileName=" + fileName).append(SEPARATOR);
        logInfoStringBuilder.append("className=" + className).append(SEPARATOR);
        logInfoStringBuilder.append("methodName=" + methodName)
                .append(SEPARATOR);
        logInfoStringBuilder.append("lineNumber=" + lineNumber);
        logInfoStringBuilder.append(" ] ");
        return logInfoStringBuilder.toString();
    }
}
