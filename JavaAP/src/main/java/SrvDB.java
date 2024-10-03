public class SrvDB implements  ActionUser{
    private String info;

    SrvDateBase srvDateBase;

    public SrvDB(SrvDateBase srvDateBase) {
        this.srvDateBase = srvDateBase;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public void GET(int t) {

    }
}
