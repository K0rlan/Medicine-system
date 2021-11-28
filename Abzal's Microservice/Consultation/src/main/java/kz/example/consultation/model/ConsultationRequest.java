package kz.example.consultation.model;

public class ConsultationRequest {
    private String consultationId;
    private Information information;

    public ConsultationRequest() {
    }

    public ConsultationRequest(String consultationId, Information information) {
        this.consultationId = consultationId;
        this.information = information;
    }

    public String getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(String consultationId) {
        this.consultationId = consultationId;
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
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
