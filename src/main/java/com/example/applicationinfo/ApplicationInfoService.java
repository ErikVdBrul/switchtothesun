package com.example.applicationinfo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class ApplicationInfoService {

    private final ApplicationInfoRepository applicationInfoRepository;

    public ApplicationInfoService(ApplicationInfoRepository applicationInfoRepository) {
        this.applicationInfoRepository = applicationInfoRepository;
    }

    public ApplicationInfo getApplicationInfo() {
        return applicationInfoRepository.getApplicationInfo();
    }

    public void updateApplicationInfo(ApplicationInfo newApplicationInfo) {
        ApplicationInfo applicationInfo = applicationInfoRepository.getApplicationInfo();
        applicationInfo.setAdminEmail(newApplicationInfo.getAdminEmail());
        applicationInfo.setTitle(newApplicationInfo.getTitle());
        applicationInfo.setVersion(newApplicationInfo.getVersion());
    }
}