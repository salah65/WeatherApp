package com.example.core.data.remote.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0004H\u0007J\u0012\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0004H\u0007J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\b\b\u0001\u0010\f\u001a\u00020\u0004H\u0007\u00a8\u0006\r"}, d2 = {"Lcom/example/core/data/remote/di/NetworkModule;", "", "()V", "provideApiKey", "", "provideBaseUrl", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "apiKey", "provideRetrofit", "Lretrofit2/Retrofit;", "okHttpClient", "baseUrl", "core_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class NetworkModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.core.data.remote.di.NetworkModule INSTANCE = null;
    
    private NetworkModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @BaseUrlQualifier()
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String provideBaseUrl() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @ApiKeyQualifier()
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String provideApiKey() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.OkHttpClient provideOkHttpClient(@ApiKeyQualifier()
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit provideRetrofit(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient, @BaseUrlQualifier()
    @org.jetbrains.annotations.NotNull()
    java.lang.String baseUrl) {
        return null;
    }
}