package com.api.Suite.dto.usersResponse;

import lombok.Data;

import java.util.List;

@Data
public class GetUsersAPIResponse {
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public List<Datum> data;
    public Support support;
}
