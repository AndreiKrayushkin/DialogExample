package com.example.rxjava;

import static java.util.Set.of;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.observers.DisposableSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String LOG = "LOG_VIEW";
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.my_text);
        Log.v(LOG, "OnCreate" + Thread.currentThread().getName());



//        Single.create(value -> {
//            for (int i = 0; i < 1000; i++) {
//                Log.v(LOG, "" + i + " threat - " + Thread.currentThread().getName());
//            }
//        })
//                .subscribeOn(Schedulers.io())
//                .subscribe();

        dataSource()
                .subscribeOn(Schedulers.io())
                .subscribe(
                        integers -> {
                            Log.v(LOG, integers.toString());
                        }, throwable -> {}
                        );

        Observable.just(1, 2, 3)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        Single.just(1)
                .subscribe(new SingleObserver<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull Integer integer) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });
        Maybe.just(1)
                .subscribe(new MaybeObserver<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onSuccess(@NonNull Integer integer) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        Completable.complete()
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onComplete() {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }
                });

        Flowable.just(1, 2, 3)
                .subscribe(new FlowableSubscriber<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Subscription s) {

                    }

                    @Override
                    public void onNext(Integer integer) {

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private Single<List<Integer>> dataSource() {
        return Single.create(subscriber -> {
            List<Integer> list = Arrays.asList(1,2,3);
//            for(int i = 0; i < 1000; i++) {
//                Log.v(LOG, "\nnumber = " + i + " thread - " + Thread.currentThread().getName());
//            }
            subscriber.onSuccess(list);
        });
    }
/*
    private Observable<Integer> newMethod() {
        return Observable.defer(() -> Observable.just(oldMethod()));
    }

    private Integer oldMethod() {
        int x = 33;
        int y = 325;
        int z = x * y;
        Log.v(LOG, "summ = " + z);
        return z;
    }*/
}