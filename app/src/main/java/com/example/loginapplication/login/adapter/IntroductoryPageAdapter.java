package com.example.loginapplication.login.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.loginapplication.R;
import com.example.loginapplication.login.bean.IntroductoryPageBean;

import java.util.ArrayList;
import java.util.List;

public class IntroductoryPageAdapter extends PagerAdapter {
    private List<IntroductoryPageBean> mList = new ArrayList<>();
    private Context mContext;
    private LayoutInflater layoutInflater;
    private OnClickNextListener onClickNextListener;

    public IntroductoryPageAdapter(Context context, List<IntroductoryPageBean>list){
        this.mContext = context;
        this.mList = list;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view = (View) object;
        container.removeView(view);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        IntroductoryPageBean bean = mList.get(position);
        View view = layoutInflater.inflate(R.layout.item_guide_page, null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.ivImage.setImageResource(bean.getResId());
        if(position == 2){
            viewHolder.tvText.setVisibility(View.VISIBLE);
        }else {
            viewHolder.tvText.setVisibility(View.INVISIBLE);
        }
        viewHolder.tvText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickNextListener != null) {
                    onClickNextListener.onClickNext();
                }
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    public static class ViewHolder{
        ImageView ivImage;
        TextView tvText;

        public ViewHolder(View contentView){
            ivImage = contentView.findViewById(R.id.iv_guide_page);
            tvText = contentView.findViewById(R.id.tv_guide_page);

        }
    }

    public void setOnClickNextListener(OnClickNextListener onClickNextListener) {
        this.onClickNextListener = onClickNextListener;
    }

    public interface OnClickNextListener{
        void onClickNext();
    }
}
