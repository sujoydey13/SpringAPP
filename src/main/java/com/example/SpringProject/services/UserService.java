package com.example.SpringProject.services;

import com.example.SpringProject.DTO.MyRequestDTO;
import com.example.SpringProject.DTO.MyResponseDTO;

public interface UserService {

    public boolean updateEmployee(MyRequestDTO request, String id);
}
