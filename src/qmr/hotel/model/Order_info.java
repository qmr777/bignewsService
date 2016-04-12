package qmr.hotel.model;

public class Order_info {
	 /**
     * errcode : 0
     * start_time : 2016-3-21
     * end_time : 2016-3-23
     * room_type : 商务房
     * room_price : 259
     * person_name : 哈哈哈哈哈哈哈
     * person_id : 555963
     * order_date : 2016-04-12
     * user_name : qmr777
     */

    public String errcode;
    public String start_time;
    public String end_time;
    public String room_type;
    public String room_price;
    public String person_name;
    public String person_id;
    public String order_date;
    public String user_name;
    public String total_cost;

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getRoom_price() {
        return room_price;
    }

    public void setRoom_price(String room_price) {
        this.room_price = room_price;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

}
