package com.example.chen.easygo.net.Bean;

import com.example.chen.easygo.net.myHttp.BaseResponse;

public class UserInfoBean extends BaseResponse {
    /**
     * data : {"driver":{"carNumber":"湘B9V29L","grade":1,"mobile":"18874864639","driverName":"罗旺","iconUrl":"https://cos.0voice.com/community/profile_150.png"}}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * driver : {"carNumber":"湘B9V29L","grade":1,"mobile":"18874864639","driverName":"罗旺","iconUrl":"https://cos.0voice.com/community/profile_150.png"}
         */

        private DriverBean driver;

        public DriverBean getDriver() {
            return driver;
        }

        public void setDriver(DriverBean driver) {
            this.driver = driver;
        }

        public static class DriverBean {
            /**
             * carNumber : 湘B9V29L
             * grade : 1
             * mobile : 18874864639
             * driverName : 罗旺
             * iconUrl : https://cos.0voice.com/community/profile_150.png
             */

            private String carNumber;
            private int grade;
            private String mobile;
            private String driverName;
            private String iconUrl;

            public String getCarNumber() {
                return carNumber;
            }

            public void setCarNumber(String carNumber) {
                this.carNumber = carNumber;
            }

            public int getGrade() {
                return grade;
            }

            public void setGrade(int grade) {
                this.grade = grade;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getDriverName() {
                return driverName;
            }

            public void setDriverName(String driverName) {
                this.driverName = driverName;
            }

            public String getIconUrl() {
                return iconUrl;
            }

            public void setIconUrl(String iconUrl) {
                this.iconUrl = iconUrl;
            }
        }
    }
}
