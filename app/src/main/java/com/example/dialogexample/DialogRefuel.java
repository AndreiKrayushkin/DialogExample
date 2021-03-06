package com.example.dialogexample;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextSwitcher;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class DialogRefuel extends DialogFragment{
    private String type_fuel;
    private int priseThisFuel;
    private final static String KEY_LOG = "LOG_VIEW_KEY";
    ImageView background_ai92;
    ImageView background_ai95;
    ImageView background_ai98;
    ImageView background_ai100;
    ImageView background_dt;
    Button buttonApplyPayFuel;
    ImageView closeDialogFragment;
    TextSwitcher textViewValueFuel;
    SeekBar seekBar;
    View view;
    TextSwitcher textViewTotalPrice;
    TextView textViewTitle;
    AlphaAnimation animator;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_refuel, container);

        getDialog()
                .getWindow()
                .setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        textViewValueFuel = view.findViewById(R.id.title_full_value);
        buttonApplyPayFuel = view.findViewById(R.id.button_apply_pay);
        seekBar = view.findViewById(R.id.seekBar);
        background_ai92 = view.findViewById(R.id.background_ai92);
        background_ai95 = view.findViewById(R.id.background_ai95);
        background_ai98 = view.findViewById(R.id.background_ai98);
        background_ai100 = view.findViewById(R.id.background_ai100);
        background_dt = view.findViewById(R.id.background_dt);
        closeDialogFragment = view.findViewById(R.id.close_dialog_fragment);

        readerTitle(type_fuel, view);

        background_ai92.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPrice(view, R.id.price_value_ai92);
                setActivityAi92();
            }
        });
        background_ai95.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPrice(view, R.id.price_value_ai95);
                setActivityAi95();
            }
        });
        background_ai98.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPrice(view, R.id.price_value_ai98);
                setActivityAi98();
            }
        });
        background_ai100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPrice(view, R.id.price_value_ai100);
                setActivityAi100();
            }
        });
        background_dt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPrice(view, R.id.price_value_dt);
                setActivityDt();
            }
        });

        /**
         * ???????????????? ?????? ???????????? ????????????. ?????? ?????????? ???????????????? ?????? ???????????????????? ????????????.
         */
        buttonApplyPayFuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(KEY_LOG, "???????????? ?????????????????? ??????????????");
                dismiss();
            }
        });

        closeDialogFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        setValueFuelFromSeekbar(seekBar);       //?????????????????? ???????????????? ?????????????? ???? ??????????????????

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                setValueFuelFromSeekbar(seekBar);
                sumTotalPrice(progress, priseThisFuel, view);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        return view;
    }

    /**
     * ???????????? ?????????? ?????????????????? ?????? ????????????
     * @param valueFuel ?????????? ??????????????
     * @param priceFuel ?????????????????? ??????????????
     * @param view
     */
    private void sumTotalPrice (int valueFuel, int priceFuel, View view) {
        textViewTotalPrice = view.findViewById(R.id.title_full_value_pay);
        int totalPrice = valueFuel * priceFuel;
        animationText(textViewTotalPrice);
        textViewTotalPrice.setText(String.valueOf(totalPrice));
    }

    /**
     * ???????????????????? ?? textView ???????????????? ?????????????????? seekBar
     * @param seekBar
     */
    private void setValueFuelFromSeekbar(SeekBar seekBar) {
        animationText(textViewValueFuel);
        textViewValueFuel.setText(String.valueOf(seekBar.getProgress()));
    }

    /**
     * ???????????????? ?????????????? ?????? ?????????????? ?????? ?????????????? ?????????? ?????????????????? ?????? ????????????
     * @param view
     * @param thisIdValue ?????????????????????????? ???????????????????? ??????????????
     */
    private void getPrice (View view, int thisIdValue) {
        TextView textViewThis = view.findViewById(thisIdValue);
        String valueGetPriceThis = textViewThis.getText().toString();
        priseThisFuel = Integer.parseInt(valueGetPriceThis);
        sumTotalPrice(seekBar.getProgress(), priseThisFuel, view);  //?????????????????????? ?????????? ?????????????????? ???? ??????????????
    }

    /**
     * ?????????? ?????????????????? ??????????????????
     */
    private void setActivityAi92() {
        setAnimationImageView(background_ai92);
        background_ai92.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.border_activity_element));
        background_ai95.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.border_not_activity_element));
        background_ai98.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.border_not_activity_element));
        background_ai100.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.border_not_activity_element));
        background_dt.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.border_not_activity_element));
    }
    private void setActivityAi95() {
        setAnimationImageView(background_ai95);
        background_ai95.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.border_activity_element));
        background_ai92.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.border_not_activity_element));
        background_ai98.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.border_not_activity_element));
        background_ai100.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.border_not_activity_element));
        background_dt.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.border_not_activity_element));
    }
    private void setActivityAi98() {
        setAnimationImageView(background_ai98);
        background_ai92.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.border_not_activity_element));
        background_ai95.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.border_not_activity_element));
        background_ai98.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.border_activity_element));
        background_ai100.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.border_not_activity_element));
        background_dt.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.border_not_activity_element));
    }
    private void setActivityAi100() {
        setAnimationImageView(background_ai100);
        background_ai92.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.border_not_activity_element));
        background_ai95.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.border_not_activity_element));
        background_ai98.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.border_not_activity_element));
        background_ai100.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.border_activity_element));
        background_dt.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.border_not_activity_element));
    }
    private void setActivityDt() {
        setAnimationImageView(background_dt);
        background_ai92.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.border_not_activity_element));
        background_ai95.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.border_not_activity_element));
        background_ai98.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.border_not_activity_element));
        background_ai100.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.border_not_activity_element));
        background_dt.setBackground(AppCompatResources.getDrawable(getContext(), R.drawable.border_activity_element));
    }

    /**
     * ?????????? ???????????????? ?????? ???????????????????????? ?????????? ????????????????
     * @param imageView
     */
    private void setAnimationImageView(ImageView imageView) {
        animator = new AlphaAnimation(.0f, 1.0f);
        animator.setDuration(200);
        imageView.startAnimation(animator);
    }

    /**
     * ?????????? ???????????????? ?????? ????????????
     * @param textSwitcher
     */
    private void animationText(TextSwitcher textSwitcher) {
        Animation inAnimation = AnimationUtils.loadAnimation(requireContext(), android.R.anim.fade_in);
        Animation outAnimation = AnimationUtils.loadAnimation(requireContext(), android.R.anim.fade_out);
        textSwitcher.setInAnimation(inAnimation);
        textSwitcher.setOutAnimation(outAnimation);
    }

    /**
     * ?????????????????????? ?? ?????????? ?????? ??????????????, ???????????????????? ?? ???????? ????????????
     * @param str - ???????????????? ???????? ??????????????
     * @param view
     */
    private void readerTitle (String str, View view) {
        textViewTitle = view.findViewById(R.id.text_header_value_fuel);
        textViewTitle.setText(str);

        switch (str) {
            case "95":
                setActivityAi95();
                getPrice(view, R.id.price_value_ai95);
                break;
            case "98":
                setActivityAi98();
                getPrice(view, R.id.price_value_ai98);
                break;
            case "100":
                setActivityAi100();
                getPrice(view, R.id.price_value_ai100);
                break;
            case "????":
                setActivityDt();
                getPrice(view, R.id.price_value_dt);
                break;
            default:
                setActivityAi92();
                getPrice(view, R.id.price_value_ai92);
                break;
        }
    }

    public void setTypeFuelValue (String str) {
        this.type_fuel = str;
    }
}