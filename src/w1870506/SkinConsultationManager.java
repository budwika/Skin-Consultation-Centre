package w1870506;

import java.io.IOException;

public interface SkinConsultationManager {
    void addDoctor();
    void deleteDoctor();
    void printDocList();
    void saveToFile() throws IOException;
    void loadFile();

}
