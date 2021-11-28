package kz.example.pharmacybranch.model;


public class ConsultationRequest {
    private String consultationId;
    private Information information;

    public ConsultationRequest() {
    }

    public ConsultationRequest(String consultationId, Information information) {
        this.consultationId = consultationId;
        this.information = information;
    }

    public String getUserId() {
        return consultationId;
    }

    public void setUserId(String userId) {
        this.consultationId = consultationId;
    }

    public Information getBook() {
        return information;
    }

    public void setBook(Information information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "BookRequest{" +
                "consultationId='" + consultationId + '\'' +
                ", Information=" + information +
                '}';
    }
}
