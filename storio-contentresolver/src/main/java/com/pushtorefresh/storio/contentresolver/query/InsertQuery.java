package com.pushtorefresh.storio.contentresolver.query;

import android.net.Uri;
import android.support.annotation.NonNull;

import static com.pushtorefresh.storio.util.Checks.checkNotNull;

/**
 * Insert query for {@link com.pushtorefresh.storio.contentresolver.StorIOContentResolver}
 * <p/>
 * Instances of this class are Immutable
 */
public class InsertQuery {

    /**
     * The content:// URI of the insertion request.
     */
    @NonNull
    public final Uri uri;

    /**
     * Please use {@link com.pushtorefresh.storio.contentresolver.query.InsertQuery.Builder} instead of constructor
     */
    protected InsertQuery(@NonNull Uri uri) {
        this.uri = uri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InsertQuery that = (InsertQuery) o;

        return uri.equals(that.uri);

    }

    @Override
    public int hashCode() {
        return uri.hashCode();
    }

    @Override
    public String toString() {
        return "InsertQuery{" +
                "uri=" + uri +
                '}';
    }

    /**
     * Builder for {@link InsertQuery}
     * <p/>
     * Yep, it looks stupid with only one parameter — Uri, but think about future,
     * we can add other things later without breaking the API!
     */
    public static class Builder {

        private Uri uri;

        /**
         * Required: Specifies uri
         *
         * @param uri content:// URI of the insertion request
         */
        @NonNull
        public Builder uri(@NonNull Uri uri) {
            this.uri = uri;
            return this;
        }

        /**
         * Builds {@link InsertQuery} instance with required params,
         * can throw {@link NullPointerException} if one of required params wasn't specify
         *
         * @return new {@link InsertQuery} instance
         */
        @NonNull
        public InsertQuery build() {
            checkNotNull(uri, "Please specify uri");

            return new InsertQuery(
                    uri
            );
        }
    }
}
