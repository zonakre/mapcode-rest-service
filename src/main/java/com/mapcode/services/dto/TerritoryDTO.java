/*
 * Copyright (C) 2015 Stichting Mapcode Foundation (http://www.mapcode.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mapcode.services.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mapcode.services.ApiConstants;
import com.tomtom.speedtools.apivalidation.ApiDTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@SuppressWarnings({"NonFinalFieldReferenceInEquals", "NonFinalFieldReferencedInHashCode", "NullableProblems", "EqualsWhichDoesntCheckParameterClass"})
@JsonInclude(Include.NON_EMPTY)
public final class TerritoryDTO extends ApiDTO {

    @Nonnull
    private String territoryNameInternational;

    @Nonnull
    private String territoryNameMinimalUnambiguous;

    @Nonnull
    private String territoryNameMinimal;

    @Nonnull
    private Integer territoryCode;

    @Nonnull
    private String fullName;

    @Nullable
    private String parentTerritory;

    @Nonnull
    private String[] aliases;

    @Nonnull
    private String[] fullNameAliases;

    @Override
    public void validate() {
        validator().start();
        validator().checkNotNull(true, "territoryNameInternational", territoryNameInternational);
        validator().checkNotNull(true, "territoryNameMinimalUnambiguous", territoryNameMinimalUnambiguous);
        validator().checkNotNull(true, "territoryNameMinimal", territoryNameMinimal);
        validator().checkInteger(true, "territoryCode", territoryCode, Integer.MIN_VALUE, Integer.MAX_VALUE);
        validator().checkString(true, "fullName", fullName, ApiConstants.API_NAME_LEN_MIN, ApiConstants.API_NAME_LEN_MAX);
        validator().checkString(false, "parentTerritory", parentTerritory, ApiConstants.API_NAME_LEN_MIN, ApiConstants.API_NAME_LEN_MAX);
        validator().checkNotNull(false, "aliases", aliases);
        validator().checkNotNull(false, "fullNameAliases", aliases);
        validator().done();
    }

    public TerritoryDTO(@Nonnull final String territoryNameInternational,
    @Nonnull final String territoryNameMinimalUnambiguous,
    @Nonnull final String territoryNameMinimal,
                        @Nonnull final Integer territoryCode,
                        @Nonnull final String fullName,
                        @Nullable final String parentTerritory,
                        @Nonnull final String[] aliases,
                        @Nonnull final String[] fullNameAliases) {
        this.territoryNameInternational = territoryNameInternational;
        this.territoryNameMinimalUnambiguous= territoryNameMinimalUnambiguous;
        this.territoryNameMinimal= territoryNameMinimal;
        this.territoryCode = territoryCode;
        this.fullName = fullName;
        this.parentTerritory = parentTerritory;
        this.aliases = aliases;
        this.fullNameAliases = fullNameAliases;
    }

    @SuppressWarnings("UnusedDeclaration")
    @Deprecated
    private TerritoryDTO() {
        // Default constructor required by JAX-B.
        super();
    }

    @Nonnull
    public String getTerritoryNameInternational() {
        beforeGet();
        return territoryNameInternational;
    }

    public void setTerritoryNameInternational(@Nonnull final String territoryNameInternational) {
        beforeSet();
        assert territoryNameInternational != null;
        this.territoryNameInternational = territoryNameInternational;
    }

    @Nonnull
    public String getTerritoryNameMinimalUnambiguous() {
        beforeGet();
        return territoryNameMinimalUnambiguous;
    }

    public void setTerritoryNameMinimalUnambiguous(@Nonnull final String territoryNameMinimalUnambiguous) {
        beforeSet();
        assert territoryNameMinimalUnambiguous != null;
        this.territoryNameMinimalUnambiguous = territoryNameMinimalUnambiguous;
    }

    @Nonnull
    public String getTerritoryNameMinimal() {
        beforeGet();
        return territoryNameMinimal;
    }

    public void setTerritoryNameMinimal(@Nonnull final String territoryNameMinimal) {
        beforeSet();
        assert territoryNameMinimal != null;
        this.territoryNameMinimal = territoryNameMinimal;
    }

    @Nonnull
    public Integer getTerritoryCode() {
        beforeGet();
        return territoryCode;
    }

    public void setTerritoryCode(@Nonnull final Integer territoryCode) {
        beforeSet();
        assert territoryCode != null;
        this.territoryCode = territoryCode;
    }

    @Nonnull
    public String getFullname() {
        beforeGet();
        return fullName;
    }

    public void setFullname(@Nonnull final String fullName) {
        beforeSet();
        assert fullName != null;
        this.fullName = fullName;
    }

    @Nullable
    public String getParentTerritory() {
        beforeGet();
        return parentTerritory;
    }

    public void setParentTerritory(@Nullable final String parentTerritory) {
        beforeSet();
        assert parentTerritory != null;
        this.parentTerritory = parentTerritory;
    }

    @Nonnull
    public String[] getAliases() {
        beforeGet();
        return aliases;
    }

    public void setAliases(@Nonnull final String[] aliases) {
        beforeSet();
        assert aliases != null;
        this.aliases = aliases;
    }

    @Nonnull
    public String[] getFullNameAliases() {
        beforeGet();
        return fullNameAliases;
    }

    public void setFullNameAliases(@Nonnull final String[] fullNameAliases) {
        beforeSet();
        assert fullNameAliases != null;
        this.fullNameAliases = fullNameAliases;
    }

    @Override
    @Nonnull
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(@Nullable final Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, false);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, false);
    }
}
