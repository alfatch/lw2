package com.amin.lw_02;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TechnologiesService {
	@GET("techs.ruleset.json")
	Call<List<Technologies>> getTechnologiesJson();
}


