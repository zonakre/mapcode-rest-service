/*
 * Copyright (C) 2016 Stichting Mapcode Foundation (http://www.mapcode.com)
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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tomtom.speedtools.apivalidation.ApiDTO;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.xml.bind.annotation.*;
import java.util.List;

@SuppressWarnings({"NonFinalFieldReferenceInEquals", "NonFinalFieldReferencedInHashCode", "NullableProblems", "EqualsWhichDoesntCheckParameterClass"})
@JsonInclude(Include.NON_EMPTY)
@XmlRootElement(name = "mapcodes")
@XmlAccessorType(XmlAccessType.FIELD)
public final class MapcodesDTO extends ApiDTO {

    @XmlElement(name = "local")
    @Nullable
    private MapcodeDTO local;

    @XmlElement(name = "international")
    @Nonnull
    private MapcodeDTO international;

    @JsonProperty("mapcodes")
    @XmlElementWrapper(name = "mapcodes")
    @XmlElement(name = "mapcode")
    @Nonnull
    private MapcodeListDTO mapcodes;

    @Override
    public void validate() {
        validator().start();
        validator().checkNotNullAndValidate(false, "local", local);
        validator().checkNotNullAndValidate(true, "international", international);
        validator().checkNotNullAndValidateAll(true, "mapcodes", mapcodes);
        validator().done();
    }

    public MapcodesDTO(
            @Nullable final MapcodeDTO local,
            @Nonnull final MapcodeDTO international,
            @Nonnull final MapcodeListDTO mapcodes) {
        this.local = local;
        this.international = international;
        this.mapcodes = mapcodes;
    }

    public MapcodesDTO(
            @Nullable final MapcodeDTO local,
            @Nonnull final MapcodeDTO international,
            @Nonnull final List<MapcodeDTO> mapcodes) {
        this(local, international, new MapcodeListDTO(mapcodes));
    }

    @SuppressWarnings("UnusedDeclaration")
    @Deprecated
    private MapcodesDTO() {
        // Default constructor required by JAX-B.
        super();
    }

    @Nullable
    public MapcodeDTO getLocal() {
        beforeGet();
        return local;
    }

    @Nonnull
    public MapcodeDTO getInternational() {
        beforeGet();
        return international;
    }

    @Nonnull
    public List<MapcodeDTO> getMapcodes() {
        beforeGet();
        return mapcodes;
    }

    public void setLocal(@Nullable final MapcodeDTO local) {
        beforeSet();
        this.local = local;
    }

    public void setInternational(@Nonnull final MapcodeDTO international) {
        beforeSet();
        assert international != null;
        this.local = international;
    }

    public void setMapcodes(@Nonnull final MapcodeListDTO mapcodes) {
        beforeSet();
        assert mapcodes != null;
        this.mapcodes = mapcodes;
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