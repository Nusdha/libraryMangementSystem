package com.example.service;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.example.entity.Admin;
import com.example.repo.AdminRepository;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin registerAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Optional<Admin> loginAdmin(String username, String password) {
        Optional<Admin> admin = adminRepository.findByUsername(username);
        if (admin.isPresent() && new SecurityAutoConfiguration.crypto.bcrypt.BCryptPasswordEncoder().matches(password,
                admin.get().getPassword())) {
            return admin;
        }
        return Optional.empty();
    }

    public Optional<Admin> findAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public Optional<Admin> deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}

