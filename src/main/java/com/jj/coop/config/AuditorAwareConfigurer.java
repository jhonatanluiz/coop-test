package com.jj.coop.config;


import com.jj.coop.security.SecurityUtils;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareConfigurer implements AuditorAware<String> {

    @Override
    public  Optional<String> getCurrentAuditor() {
       return SecurityUtils.getCurrentUserLogin();
    }

}
