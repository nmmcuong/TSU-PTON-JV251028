package Ex2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Appointment {
    private String appointmentId;
    private String patientName;
    private String phoneNumber;
    private LocalDate appointmentDate;
    private String doctor;

    public Appointment() {}

    public Appointment(String appointmentId, String patientName, String phoneNumber, LocalDate appointmentDate, String doctor) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.phoneNumber = phoneNumber;
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
    }

    // Getters and Setters
    public String getAppointmentId() { return appointmentId; }
    public void setAppointmentId(String appointmentId) { this.appointmentId = appointmentId; }
    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public LocalDate getAppointmentDate() { return appointmentDate; }
    public void setAppointmentDate(LocalDate appointmentDate) { this.appointmentDate = appointmentDate; }
    public String getDoctor() { return doctor; }
    public void setDoctor(String doctor) { this.doctor = doctor; }

    public void inputData(Scanner scanner, List<Appointment> list, boolean isUpdate) {
        if (!isUpdate) {
            while (true) {
                System.out.print("Nhập mã lịch hẹn (6 ký tự): ");
                this.appointmentId = scanner.nextLine();
                boolean isExist = list.stream().anyMatch(a -> a.getAppointmentId().equals(this.appointmentId));
                if (this.appointmentId.length() == 6 && !isExist) break;
                System.err.println("Mã phải đúng 6 ký tự và không được trùng lặp!");
            }
        }

        while (true) {
            System.out.print("Nhập tên bệnh nhân (10-50 ký tự): ");
            this.patientName = scanner.nextLine();
            if (this.patientName.length() >= 10 && this.patientName.length() <= 50) break;
            System.err.println("Tên không hợp lệ!");
        }

        while (true) {
            System.out.print("Nhập số điện thoại VN (ví dụ 0912345678): ");
            this.phoneNumber = scanner.nextLine();
            if (this.phoneNumber.matches("^(03|05|07|08|09)\\d{8}$")) break;
            System.err.println("Số điện thoại không đúng định dạng Việt Nam!");
        }

        while (true) {
            System.out.print("Nhập ngày khám (dd/MM/yyyy): ");
            String dateStr = scanner.nextLine();
            try {
                this.appointmentDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            } catch (DateTimeParseException e) {
                System.err.println("Định dạng ngày không đúng (dd/MM/yyyy)!");
            }
        }

        while (true) {
            System.out.print("Nhập bác sĩ phụ trách: ");
            this.doctor = scanner.nextLine();
            if (!this.doctor.isEmpty() && this.doctor.length() <= 200) break;
            System.err.println("Bác sĩ không được để trống và tối đa 200 ký tự!");
        }
    }

    @Override
    public String toString() {
        return String.format("ID: %s | BN: %-20s | SĐT: %s | Ngày: %s | BS: %s",
                appointmentId, patientName, phoneNumber, 
                appointmentDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), doctor);
    }
}
