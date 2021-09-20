/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2021 iText Group NV
    Authors: iText Software.

    This program is offered under a commercial and under the AGPL license.
    For commercial licensing, contact us at https://itextpdf.com/sales.  For AGPL licensing, see below.

    AGPL licensing:
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.itextpdf.commons.actions;

import com.itextpdf.commons.actions.contexts.IMetaInfo;
import com.itextpdf.commons.actions.data.ProductData;
import com.itextpdf.commons.exceptions.CommonsExceptionMessageConstant;

/**
 * Represents a context-based event. See also {@link AbstractContextBasedEventHandler}.
 * Only for internal usage.
 */
public abstract class AbstractContextBasedITextEvent extends AbstractProductITextEvent {
    private IMetaInfo metaInfo;

    /**
     * Creates an event containing auxiliary meta data.
     *
     * @param productData is a description of the product which has generated an event
     * @param metaInfo is an auxiliary meta info
     */
    protected AbstractContextBasedITextEvent(ProductData productData, IMetaInfo metaInfo) {
        super(productData);
        this.metaInfo = metaInfo;
    }

    /**
     * Obtains the current event context class.
     *
     * @return context class
     */
    public Class<?> getClassFromContext() {
        return this.getClass();
    }

    /**
     * Sets meta info.
     *
     * @param metaInfo meta info
     *
     * @throws IllegalStateException if the current event already has not null meta info associated with it
     */
    public void setMetaInfo(IMetaInfo metaInfo) throws IllegalStateException {
        if (this.metaInfo != null) {
            throw new IllegalStateException(CommonsExceptionMessageConstant.META_INFO_SHOULDNT_BE_NULL);
        }
        this.metaInfo = metaInfo;
    }

    /**
     * Obtains stored meta info associated with the event.
     *
     * @return meta info
     */
    IMetaInfo getMetaInfo() {
        return metaInfo;
    }
}
