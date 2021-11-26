/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import Model.TaiKhoan;

public class XAuth {

    public static TaiKhoan user = null;

    public static void clear() {
        XAuth.user = null;
    }

    public static int isLogin() {
        if (XAuth.user != null) {
            return 1;
        } else {
            return 0;
        }
    }

    public static boolean isManager() {
        if (isLogin() == 1) {
            XAuth.user.getVaiTro();
            return true;
        } else {
            return false;
        }

    }
}
