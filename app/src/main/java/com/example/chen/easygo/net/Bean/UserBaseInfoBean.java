package com.example.chen.easygo.net.Bean;

import com.example.chen.easygo.net.myHttp.BaseResponse;

public class UserBaseInfoBean extends BaseResponse {
    /**
     * data : {"driver":{"cityName":"长沙","identityNumber":"430211198509111073","cityCode":430100,"driverName":"罗旺","firstIssueDate":"20120229"}}
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
         * driver : {"cityName":"长沙","identityNumber":"430211198509111073","cityCode":430100,"driverName":"罗旺","firstIssueDate":"20120229"}
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
             * cityName : 长沙
             * identityNumber : 430211198509111073
             * cityCode : 430100
             * driverName : 罗旺
             * firstIssueDate : 20120229
             */

            private String cityName;
            private String identityNumber;
            private int cityCode;
            private String driverName;
            private String firstIssueDate;

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public String getIdentityNumber() {
                return identityNumber;
            }

            public void setIdentityNumber(String identityNumber) {
                this.identityNumber = identityNumber;
            }

            public int getCityCode() {
                return cityCode;
            }

            public void setCityCode(int cityCode) {
                this.cityCode = cityCode;
            }

            public String getDriverName() {
                return driverName;
            }

            public void setDriverName(String driverName) {
                this.driverName = driverName;
            }

            public String getFirstIssueDate() {
                return firstIssueDate;
            }

            public void setFirstIssueDate(String firstIssueDate) {
                this.firstIssueDate = firstIssueDate;
            }
        }
    }
}
