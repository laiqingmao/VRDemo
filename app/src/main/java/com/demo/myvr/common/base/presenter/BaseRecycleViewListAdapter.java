package com.demo.myvr.common.base.presenter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.demo.myvr.R;
import com.demo.myvr.common.base.view.ListItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * RecycleView适配器
 * Created by Administrator on 2017/1/9.
 */
public abstract class BaseRecycleViewListAdapter<ItemView extends ListItemView<DATA>, DATA>
		extends RecyclerView.Adapter<BaseRecycleViewListAdapter.BaseRecycleViewHolder> {

	protected List<DATA> mData = new ArrayList<>();
	private static final int KEY = R.id.back_button;
	private OnItemClickListener mOnItemClickListener;
	private View.OnClickListener mListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			int position = (int) v.getTag(KEY);
			if (mOnItemClickListener != null) {
				mOnItemClickListener.onItemClick(v, position);
			}
		}
	};
	
	@Override
	public BaseRecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		ItemView itemView = getItemView(parent, viewType);
		itemView.setOnClickListener(mListener);
		return new BaseRecycleViewHolder(itemView);
	}
	
	protected abstract ItemView getItemView(ViewGroup parent, int viewType);
	
	@Override
	public void onBindViewHolder(BaseRecycleViewHolder holder, int position) {
		ItemView itemView = (ItemView) holder.getItemView();
		itemView.setTag(KEY, position);
		itemView.bind(mData.get(position), position);
	}

	@Override
	public int getItemCount() {
		return mData.size();
	}

	public void setData(List<DATA> list) {
		mData.clear();
		mData.addAll(list);
		notifyDataSetChanged();
	}

	public void addData(List<DATA> list) {
		mData.addAll(list);
		notifyItemChanged(mData.size(), list.size());
	}

	public List<DATA> getData() {
		return mData;
	}

	public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
		mOnItemClickListener = onItemClickListener;
	}

	public interface OnItemClickListener {
		void onItemClick(View view, int position);
	}

	static class BaseRecycleViewHolder extends RecyclerView.ViewHolder {
		BaseRecycleViewHolder(View itemView) {
			super(itemView);
		}

		View getItemView() {
			return itemView;
		}
	}
}




