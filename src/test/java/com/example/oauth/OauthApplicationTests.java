package com.example.oauth;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.oauth.security.SecurityConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@ImportAutoConfiguration(SecurityConfiguration.class)
@AutoConfigureMockMvc
class OauthApplicationTests {

  @Autowired
  private MockMvc mockMvc;

  //  @WithMockUser(authorities = "USER")
  @Test
  void endpointWithPermittedUri() throws Exception {
    this.mockMvc.perform(get("/public"))
        .andExpect(status().isOk());
  }

  //  @WithMockUser
  @Test
  void endpointWithAuthenticatedUri() throws Exception {
    this.mockMvc.perform(get("/private"))
        .andExpect(status().isUnauthorized());
  }

}
