
package UI.LeTan;

/**
 *
 * @author DELL
 */
public class Time {
    private int minute; 
    private int hour; 

    public Time() {
        this.minute = 0;
        this.hour = 0;
    }

    public Time(int hour, int minute) {
        this.minute = minute;
        this.hour = hour;
    }
    public Time(String str) {
        String ThoiGian[] = str.split(":");
        int gio = Integer.valueOf(ThoiGian[0]);
        int phut = Integer.valueOf(ThoiGian[1]);
        this.minute = phut;
        this.hour = gio;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        if (minute >= 0 && minute < 60) {
            this.minute = minute;
        } else {
            this.minute = 0;
        }
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (hour >= 0 && hour < 24) {
            this.hour = hour;
        } else {
            this.hour = 0;
        }
    }

    @Override
    public String toString() {
        String str = hour + "";
        str += ":";
        if (minute < 10) {
            str += "0";
        } else {
            str += "";
        }
        str += minute;

        return str;
    }

    public void tangPhut() {
        this.setMinute(this.minute + 30);
        if (this.minute == 0) {
            tangGio();
        }
    }

    public void tangGio() {
        this.setHour(this.hour + 1);
    }

    public int SoSanh(String str) {
        String ThoiGian[] = str.split(":");
        int gio = Integer.valueOf(ThoiGian[0]);
        int phut = Integer.valueOf(ThoiGian[1]);
        if (hour < gio) {
            return -1;
        } else if (hour > gio) {
            return 1;
        } else {
            if (minute < phut) {
                return -1;
            } else if (minute > phut) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
