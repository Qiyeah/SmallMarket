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
            System.out.println("-------------------------欢迎使用模拟超市系统----------------------------");
            System.out.println("|-1.登陆系统\n|-2.系统注册\n|-3.关闭系统");
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
                System.out.println("页面提示：系统即将退出... ...");
                System.exit(0);
            } else {
                System.out.println("页面提示：输入出错，请根据提示输入");
            }
        }
    }
}
