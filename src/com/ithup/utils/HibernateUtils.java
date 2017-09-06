package com.ithup.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * hibernate������
 * @author acer
 *
 */
public class HibernateUtils {
	public static final Configuration CONFIGURATION;
	public static final SessionFactory FACTORY;
	//��д��̬�����
	static{
		//����xml�����ļ�
		CONFIGURATION = new Configuration().configure();
		//���칤��
		FACTORY = CONFIGURATION.buildSessionFactory();
	}
	
	/**
	 * ��������session�Ķ���
	 * @return
	 */
	public static Session getSession(){
		return FACTORY.openSession();
	}
	/**
	 * // ��ThreadLocal���л�ȡ��session�Ķ���
	 * @return
	 */
	public static Session getCurrentSession(){
		return FACTORY.getCurrentSession();
	}
	
	public static void main(String[] args){
		getSession();
	}
}
