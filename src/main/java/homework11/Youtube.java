package homework11;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Youtube {

    private Double apiVersion;
    private Data data;

    public Double getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(Double apiVersion) {
        this.apiVersion = apiVersion;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}