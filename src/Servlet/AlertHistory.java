package Servlet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artem Klimenko on 23 Jan 2017.
 */
public class AlertHistory implements Serializable{

        private List<AlertStaff> alerts;

        public AlertHistory() {
            this.alerts = new ArrayList<AlertStaff>();
        }

        public void addMessage(AlertStaff alert){
            

            this.alerts.add(alert);
        }

        public List<AlertStaff> getalerts(){
            return this.alerts;
        }

 }