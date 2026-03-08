package com.back.boundedContexts.member.domain.shared.memberExtensions

import com.back.boundedContexts.member.domain.shared.Member
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority

val Member.authoritiesAsStringList: List<String>
    get() = buildList {
        if (isAdmin) add("ROLE_ADMIN")
    }

val Member.authorities: Collection<GrantedAuthority>
    get() = authoritiesAsStringList.map(::SimpleGrantedAuthority)
