package com.huayu.A11_3.View;

import com.huayu.A11_3.Controller.Login;
import com.huayu.A11_3.Controller.Register;
import com.huayu.A11_3.Util.GetData;

/**
 * Created by Qiyeah on 2015/10/16.
 */
public class Index {
    public static void main(String[] args) {
        for (int i = 0; i < 1;) {
            GetData gd = new GetData();
            System.out.println("-------------------------��ӭʹ��ģ�ⳬ��ϵͳ----------------------------");
            System.out.println("|-1.��½ϵͳ\n|-2.ϵͳע��\n|-3.�ر�ϵͳ");
            System.out.println("-------------------------------------------------------------------------");
            String cmd1 = gd.getData();
            if ("1".equals(cmd1)) {
                i++;
                new Login().login();
            } else if ("2".equals(cmd1)) {
                i++;
                new Register().regBuyer();
            } else if ("3".equals(cmd1)) {
                i++;
                System.out.println("ҳ����ʾ��ϵͳ�����˳�... ...");
                System.exit(0);
            } else {
                System.out.println("ҳ����ʾ����������������ʾ����");
            }
        }
    }
}
